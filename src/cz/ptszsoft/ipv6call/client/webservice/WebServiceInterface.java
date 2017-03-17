package cz.ptszsoft.ipv6call.client.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceInterface {
	@WebMethod String ping();
	@WebMethod String version();
	@WebMethod String receiveString(String message);
}
