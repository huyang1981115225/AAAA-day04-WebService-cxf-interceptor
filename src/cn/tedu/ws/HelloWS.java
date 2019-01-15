package cn.tedu.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * SEI:
 * @WebService(SEI 和SEI的实现类)
 * @WebMethod(SEI中的所有方法)
 * 
 * EndPoint(发布WebService)
 * 
 * @author HY
 * 
 *
 */
@WebService
public interface HelloWS {
	
	
	/**
	 * @WebMethod(SEI中的所有方法)
	 */
	@WebMethod
	public String sayHello(String name);
	
	@WebMethod
	public String introduce(String name,Integer age);
}
