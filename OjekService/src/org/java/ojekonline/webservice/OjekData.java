package org.java.ojekonline.webservice;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface OjekData {

	@WebMethod
	public Boolean validateToken(String token);
}
