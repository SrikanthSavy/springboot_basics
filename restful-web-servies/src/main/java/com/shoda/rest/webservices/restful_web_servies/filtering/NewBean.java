package com.shoda.rest.webservices.restful_web_servies.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("NewBeanFilter")
public class NewBean {
	
	private String field1;
	private String field2;
	private String field3;
	public NewBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	public String getField1() {
		return field1;
	}
	public String getField2() {
		return field2;
	}
	public String getField3() {
		return field3;
	}
	@Override
	public String toString() {
		return "NewBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}

}
