package com.xml.reader.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;

import com.xml.reader.model.Address;
import com.xml.reader.model.Employee;
import com.xml.reader.model.NodeName;
import com.xml.reader.parser.XmlDomParser;

public abstract class ReadXmlAsync extends AsyncTask<String, Integer, Object> {
	private XmlDomParser parser;
	private Context context;
	private AssetManager assetManager;
	private InputStream inputStream;
	private ArrayList<Employee> employees = null;

	public abstract void getResult(ArrayList<Employee> employees);

	public ReadXmlAsync(Context context) {
		super();
		this.context = context;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();

		parser = new XmlDomParser();
		assetManager = context.getAssets();
	}

	@Override
	protected Object doInBackground(String... params) {
		// TODO Auto-generated method stub
		try {
			inputStream = assetManager.open(params[0]);
			Document doc = parser.getDocument(inputStream);

			NodeList nodeList = doc.getElementsByTagName(NodeName.NODE_EMP);
			employees = new ArrayList<Employee>();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element e = (Element) nodeList.item(i);

				Address employeesAddress = new Address(parser.getValue(e,
						NodeName.NODE_LINE1), parser.getValue(e,
						NodeName.NODE_CITY), parser.getValue(e,
						NodeName.NODE_STATE), Long.parseLong(parser.getValue(e,
						NodeName.NODE_ZIP).trim()));

				Employee employee = new Employee(parser.getValue(e,
						NodeName.NODE_NAME), Integer.parseInt(e
						.getAttribute(NodeName.ATTR_ID)), parser.getValue(e,
						NodeName.NODE_DEPT), parser.getValue(e,
						NodeName.NODE_TYPE), parser.getValue(e,
						NodeName.NODE_EMAIL), employeesAddress);

				employees.add(employee);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	protected void onPostExecute(Object result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		getResult((ArrayList<Employee>) result);
	}
}
