package com.xml.reader.controller;

import java.util.ArrayList;

import android.content.Context;

import com.xml.reader.client.ReadXmlAsync;
import com.xml.reader.listener.OnXmlParsedListener;
import com.xml.reader.model.Employee;

public class XmlController {
	private OnXmlParsedListener onXmlParsedListener;
	private Context context;

	public XmlController(OnXmlParsedListener onXmlParsedListener,
			Context context) {
		super();
		this.onXmlParsedListener = onXmlParsedListener;
		this.context = context;
	}

	public void doParse(String documentName) {
		ReadXmlAsync readXml = new ReadXmlAsync(context) {

			@Override
			public void getResult(ArrayList<Employee> employees) {
				// TODO Auto-generated method stub
				onXmlParsedListener.onXmlParsed(employees);
			}
		};
		readXml.execute(documentName);
		onXmlParsedListener.onXmlParsingRequested();
	}
}
