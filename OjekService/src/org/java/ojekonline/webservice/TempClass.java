package org.java.ojekonline.webservice;

import javax.xml.bind.annotation.XmlRootElement;

public class TempClass {
	private String key;
	private Object val;
	
	public TempClass() {
		key = null;
		val = null;
	}
	
	public TempClass(String key, Object val) {
		this.key = key;
		this.val = val;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setVal(Object val) {
		this.val = val;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public Object getVal() {
		return this.val;
	}
}
