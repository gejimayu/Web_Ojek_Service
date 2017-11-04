package org.java.ojekonline.webservice;
import javax.jws.WebService;
import java.sql.*;
import com.mysql.jdbc.Statement;

@WebService(endpointInterface="org.java.ojekonline.webservice.OjekData")
public class OjekDataImpl implements OjekData{

	@Override
	public Boolean validateToken(String token) {
		return true;
	}
	
	public String getUsername() {
		return "wkwk";
	}
	
	public String getPhoneNumber() {
		return "0858 8337 0812";
	}

}
