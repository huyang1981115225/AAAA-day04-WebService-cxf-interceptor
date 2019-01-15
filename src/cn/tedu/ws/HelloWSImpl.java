package cn.tedu.ws;

import javax.jws.WebService;

/**
 * SEI实现类
 * @WebService(SEI 和SEI的实现类)
 * 
 * @author HY
 *
 */

@WebService
public class HelloWSImpl implements HelloWS {

	/**
	 * @WebMethod注解实现类,所以方法就不用加了
	 */
	@Override
	public String sayHello(String name) {
		System.out.println("Server sayHello() "+name);
		return "Hello,I'am "+name;
	}

	@Override
	public String introduce(String name, Integer age) {
		System.out.println("Server introduce() "+name+","+age);
		return "I'm "+name+",and I'm "+age+" years old.";
	}
}
