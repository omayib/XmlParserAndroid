package com.xml.reader.listener;

import java.util.ArrayList;

import com.xml.reader.model.Employee;

public interface OnXmlParsedListener {
	void onXmlParsed(ArrayList<Employee> employees);

	void onXmlParsingRequested();
}
