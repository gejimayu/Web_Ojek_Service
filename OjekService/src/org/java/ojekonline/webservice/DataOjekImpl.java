package org.java.ojekonline.webservice;
import javax.jws.WebService;

@WebService(endpointInterface="org.java.ojekonline.webservice.DataOjek")
public class DataOjekImpl implements DataOjek{

	@Override
	public String validateToken(String token) {
		return "Hello world" + token;
	}

}
