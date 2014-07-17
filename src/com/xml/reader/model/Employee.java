package com.xml.reader.model;

public class Employee {
	private String name;
	private int id;
	private String department;
	private String type;
	private String email;
	private Address address;

	public Employee(String name, int id, String department, String type,
			String email, Address address) {
		super();
		this.name = name;
		this.id = id;
		this.department = department;
		this.type = type;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return id + ": " + name + "\n" + department + "-" + type;
	}

	public String getDetails() {
		String result = id + ": " + name + "\n" + department + "-" + type
				+ "\n" + email + "\n" + "Address:\n" + address.getLine() + "\n"
				+ address.getCity() + ", " + address.getState() + " "
				+ address.getZipcode();
		return result;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}