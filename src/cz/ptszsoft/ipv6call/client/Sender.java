package cz.ptszsoft.ipv6call.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import cz.ptszsoft.ipv6call.client.webservice.WebServiceInterface;

public class Sender {

	public static Boolean ping(String wsdlURL) {
		try {
			URL url = new URL(wsdlURL);
			QName qname = new QName("http://clientresponder.ipv6call.ptszsoft.cz/", "WebServiceImplementationService");
			Service service = Service.create(url, qname);
			qname = new QName("http://clientresponder.ipv6call.ptszsoft.cz/", "WebServiceImplementationPort");
			WebServiceInterface hello = service.getPort(qname, WebServiceInterface.class);
			return (hello.ping() == "OK");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static Boolean sendMessage(String wsdlURL,String message) {
		try {
			URL url = new URL(wsdlURL);
			QName qname = new QName("http://clientresponder.ipv6call.ptszsoft.cz/", "WebServiceImplementationService");
			Service service = Service.create(url, qname);
			qname = new QName("http://clientresponder.ipv6call.ptszsoft.cz/", "WebServiceImplementationPort");
			WebServiceInterface hello = service.getPort(qname, WebServiceInterface.class);
			return (hello.receiveString(message) == "OK");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
