package org.java.ojekonline.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.ArrayList;
import java.util.Map;

@XmlRootElement( name = "Babi" )
public class Babi {  
	private ArrayList<Map<String, String>> results;
	
	public Babi() {
		results = new ArrayList<Map<String, String>>();
	}
	 
	public Babi(ArrayList<Map<String, String>> results) {
		this.results = results;
	}
	
	public void setResults(ArrayList<Map<String, String>> results) {
		this.results = results;
	}
	
	@XmlJavaTypeAdapter(MapAdapter.class)    
	public ArrayList<Map<String, String>> getResults() {
		return this.results;
	}
}