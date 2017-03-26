package cz.ptszsoft.ipv6call.client;

import javax.swing.SwingUtilities;
import javax.xml.ws.Endpoint;

import cz.genisoft.library.ip.IPv6info;
import cz.ptszsoft.ipv6call.client.webservice.WebServiceImplementation;

public class ReceiverPublisher {

	public static void main(String[] args) {
		try {
			String wsURL = "http://[" + IPv6info.getLocalIPv6() + "]:9997/ipv6client";
			System.out.println(wsURL + "?wsdl");
			Endpoint.publish(wsURL, new WebServiceImplementation());
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					MainWindow.main();
				}
			});
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}
