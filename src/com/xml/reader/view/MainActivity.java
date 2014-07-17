package com.xml.reader.view;

import java.util.ArrayList;

import com.xml.reader.R;
import com.xml.reader.controller.XmlController;
import com.xml.reader.listener.OnXmlParsedListener;
import com.xml.reader.model.Employee;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements OnXmlParsedListener {
	private XmlController xmlController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		xmlController = new XmlController(this, this);
		xmlController.doParse("employees.xml");

	}

	@Override
	public void onXmlParsed(ArrayList<Employee> employees) {
		// TODO Auto-generated method stub
		for (Employee employee : employees) {
			System.out.println("===========================");
			// System.out.println(employee.getName());
			// System.out.println(employee.getAddress().getCity());
			System.out.println(employee.toString());
		}
	}

	@Override
	public void onXmlParsingRequested() {
		// TODO Auto-generated method stub
		System.out.println("requested");
	}
}
