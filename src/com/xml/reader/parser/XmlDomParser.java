package com.xml.reader.parser;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlDomParser {
	public Document getDocument(InputStream inputStream) {

		Document document = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource inputSource = new InputSource(inputStream);
			document = builder.parse(inputSource);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return document;
	}

	public String getValue(Element item, String name) {
		NodeList nodes = item.getElementsByTagName(name);
		return this.getNodeValue(nodes.item(0));
	}

	public String getNodeValue(Node currentNode) {
		Node child;
		if (currentNode == null)
			return "";

		if (currentNode.hasChildNodes()) {
			child = currentNode.getFirstChild();
			while (child != null) {
				if (child.getNodeType() == Node.TEXT_NODE) {
					return child.getNodeValue();
				}
				child = child.getNextSibling();
			}
		}

		return "";

	}
}
