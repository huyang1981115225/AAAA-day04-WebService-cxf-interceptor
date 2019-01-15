package cn.tedu.server;

import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws22.EndpointImpl;
import org.apache.cxf.message.Message;

import cn.tedu.myInterceptor.CheckUserInterceptor;
import cn.tedu.ws.HelloWSImpl;

/**
 * 演示CXF的自己定义的拦截器-----服务器端
 * 
 * @author HY
 *
 */
public class ServerTest_myInterceptor {
	public static void main(String[] args) {
		String address = "http://localhost:7777/AAAA-day04-WebService-cxf-interceptor/interceptorws";
		Endpoint endpoint = Endpoint.publish(address, new HelloWSImpl());
		System.out.println(endpoint);
		EndpointImpl endpointImpl = (EndpointImpl) endpoint;

		//服务端的自己定义的入拦截器
		List<Interceptor<? extends Message>> inInterceptors = endpointImpl.getInInterceptors();
		inInterceptors.add(new CheckUserInterceptor());
		
		System.out.println("CXF_Interceptor ------WebService已经发布成功!");
	}
}
