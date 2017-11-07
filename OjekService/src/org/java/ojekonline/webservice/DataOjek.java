package org.java.ojekonline.webservice;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface DataOjek {

	 @WebMethod 
	 public String validateToken(String token);
	
}
