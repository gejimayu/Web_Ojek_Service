package org.java.ojekonline.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.Map;

@XmlRootElement( name = "Babi" )
public class Babi {
	
	private ArrayList<String> results;
	
	public Babi() {
		results = new ArrayList<String>();
	}
	
	public Babi(ArrayList<String> results) {
		for (String isi : results) {
			this.results.add(isi);
		}
	}
	
	public void setResults(ArrayList<String> results) {
		this.results = results;
	}
	
	public ArrayList<String> getResults() {
		return this.results;
	}
}
