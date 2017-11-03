package org.java.ojekonline.webservice;
import javax.jws.WebService;

@WebService(endpointInterface="org.java.ojekonline.webservice.OjekData")
public class OjekDataImpl implements OjekData{

	@Override
	public Boolean validateToken(String token) {
		return true;
	}

}
