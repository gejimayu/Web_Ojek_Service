package org.java.ojekonline.webservice;
import javax.xml.ws.Endpoint;

public class DataOjekPublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8089/WS/DataOjek", new DataOjekImpl());
	}
}
