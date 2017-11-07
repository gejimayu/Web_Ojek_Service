package org.java.ojekonline.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;

import java.util.ArrayList;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface OjekData {
	
	@WebMethod
	public Boolean validateToken(String token);
	
	@WebMethod
	public Babi findDriver(int id_user, String pick, String dest);
	
	@WebMethod
	public Profile getProfileInfo(int id_user);
	
	@WebMethod
	public Babi listLocation(int id_user);
	
	@WebMethod
	public void addLocation(int id_driver, String location);
	
	@WebMethod
	public void deleteLocation(int id_driver, String location);
	
	@WebMethod
	public void saveLocation(int id_driver, String old_loc, String new_load);
}
