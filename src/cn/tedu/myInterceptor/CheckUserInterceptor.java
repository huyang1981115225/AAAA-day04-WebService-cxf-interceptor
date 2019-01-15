package cn.tedu.myInterceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import javax.xml.namespace.QName;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

/**
 * 自己定义的拦截器
 * 检查用户的拦截器
 * 
 * @author HY
 *
 */
public class CheckUserInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	public CheckUserInterceptor() {
		super(Phase.PRE_PROTOCOL);
	}

	/**
	 * <Envelope>
	 * 		<head>
	 * 			<atguigu>
	 * 				<name>zhangsan</name>
	 * 				<password>123456</password>
	 * 			</atguigu>
	 * 			<atguigu2>
	 * 				<name>lisi</name>
	 * 				<password>123456</password>
	 * 			</atguigu2>
	 * 		</head>
	 * 		<body>
	 * 			<sayHello>
	 * 				<arg0>BOB</arg0>
	 * 			</sayHello>
	 * 		</body>
	 * </Envelope>
	 */
	@Override
	public void handleMessage(SoapMessage msg) throws Fault {
		Header header = msg.getHeader(new QName("atguigu"));
		if(header!=null) {
			Element atguiguEle = (Element) header.getObject();
			String name = atguiguEle.getElementsByTagName("name").item(0).getTextContent();
			String password = atguiguEle.getElementsByTagName("password").item(0).getTextContent();
			if("zhangsan".equals(name) && "123456".equals(password)) {
				System.out.println("Server 通过拦截器....");
				return;
			}
		}
		//不能通过
		System.out.println("Server 没有通过拦截器....");
		throw new Fault(new RuntimeException("请求需要一个正确的用户名和密码!"));
	}

}
