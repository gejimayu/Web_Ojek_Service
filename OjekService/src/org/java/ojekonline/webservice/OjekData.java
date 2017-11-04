package org.java.ojekonline.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface OjekData {
	
	@WebMethod
	public Boolean validateToken(String token);
	
	@WebMethod
	public Babi findDriver(int id_user, String pick, String dest);
	
	@WebMethod
	public Profile getProfileInfo(int id_user);
}
