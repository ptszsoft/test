package cz.ptszsoft.ipv6call.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import cz.ptszsoft.ipv6call.server.webservice.WebServiceInterface;
import cz.ptszsoft.ipv6call.types.UsersList;

public class ServerCommunication {
	
	public static Boolean ping(String wsdlURL) {
		try {
			URL url = new URL(wsdlURL);
			QName qname = new QName("http://webservice.client.ipv6call.ptszsoft.cz/", "WebServiceImplementationService");
			Service service = Service.create(url, qname);
			qname = new QName("http://webservice.client.ipv6call.ptszsoft.cz/", "WebServiceImplementationPort");
			WebServiceInterface hello = service.getPort(qname, WebServiceInterface.class);
			return (hello.ping() == "OK");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static UsersList getUsersList(String wsdlURL,String iamUser) {
		UsersList userList = new UsersList();
		try {
			URL url = new URL(wsdlURL);
			QName qname = new QName("http://webservice.client.ipv6call.ptszsoft.cz/", "WebServiceImplementationService");
			Service service = Service.create(url, qname);
			qname = new QName("http://webservice.client.ipv6call.ptszsoft.cz/", "WebServiceImplementationPort");
			WebServiceInterface hello = service.getPort(qname, WebServiceInterface.class);
			userList= hello.getMyUserList(iamUser);
			System.out.println(userList.size());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	

}
