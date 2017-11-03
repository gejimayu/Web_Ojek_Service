package org.java.ojekonline.webservice;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface OjekData {

	@WebMethod
	public Boolean validateToken(String token);
}
