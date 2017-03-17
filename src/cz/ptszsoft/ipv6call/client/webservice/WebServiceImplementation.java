/**
 * 
 */
package cz.ptszsoft.ipv6call.client.webservice;

import javax.jws.WebService;

/**
 * @author genisoft
 *
 */
//@WebService(endpointInterface = "cz.ptszsoft.ipv6call.clientresponder.Receiver")
@WebService
public class WebServiceImplementation implements WebServiceInterface {
	
	/**
	 * @param args
	 */
	@Override
	public String ping() {
		return "OK";
	}
	
	/**
	 * @param args
	 */
	@Override
	public String version() {
		return "0.1.1";
	}
	
	/**
	 * @param args
	 */
	@Override
	public String receiveString(String message) {
		return "OK";
	}
	

}
