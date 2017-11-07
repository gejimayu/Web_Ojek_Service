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
	public String getNameUser(int id_user);
	
	@WebMethod
	public Babi findPrefDriver(int id_user, String name);
	
	@WebMethod
	public Babi getProfile(int id_user, int driverstatus);
	
	@WebMethod
	public void insertOrder(int id_driver, int id_user, String tgl, String pick, String dest, int rate, String comment);
	
	@WebMethod
	public void updateDriver(int id_driver, int num_votes, float avgrating);
	
	@WebMethod
	public void insertHistory(int id_user, int id_driver, String tgl, String nameuser, String namedriver, 
			String pick, String dest, int rate, String comment, int hide, int driverstatus);
	
	@WebMethod
	public Babi getUserHistory(int id_user);
	
	@WebMethod
	public Babi getDriverHistory(int id_driver);
	
	@WebMethod
	public void hideUserHistory(int id_history);
	
	@WebMethod
	public void hideDriverHistory(int id_history);
	
	@WebMethod
	public void insertUser(String name, String username, String prof_pic, String email, String phone_number,
			String driver_status);
}
