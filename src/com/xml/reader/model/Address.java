package com.xml.reader.model;

public class Address {

	private String line;
	private String city;
	private String state;
	private long zipcode;

	public Address(String line, String city, String state, long zipcode) {
		super();
		this.line = line;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getZipcode() {
		return zipcode;
	}

	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
}