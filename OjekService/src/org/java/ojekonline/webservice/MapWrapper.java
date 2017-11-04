package org.java.ojekonline.webservice;

import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class MapWrapper {

	@XmlJavaTypeAdapter(MapAdapter.class)    
    Map<String, String> books;
	
}
