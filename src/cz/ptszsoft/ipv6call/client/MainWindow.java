package cz.ptszsoft.ipv6call.client;

import java.awt.Color;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import cz.ptszsoft.ipv6call.server.webservice.WebServiceInterface;
import cz.ptszsoft.ipv6call.types.UsersList;

public class MainWindow {

	public static void addMessage(String message) {
	}

	public static void main() {

		// frame.add(new JLabel(Info.getLocalIPv6()));
		JPanel panelL = new JPanel();
		panelL.setLayout(new GridLayout(4, 1));
		panelL.setBackground(Color.yellow);
		DefaultListModel<String> users = new DefaultListModel<String>();
		//ArrayList<String> userList = ServerCommunication.getUsersList("http://[2002:bc78:cb94:1:555:c207:db6:c418]:9998/ipv6server","jzeman");
		
		UsersList userList = new UsersList();
		try {
			URL url = new URL("http://[2002:bc78:cb94:1:a46c:ca94:1e6c:eea5]:9998/ipv6server");
			QName qname = new QName("http://serverresponder.ipv6call.ptszsoft.cz/", "ReceiverService");
			Service service = Service.create(url, qname);
			qname = new QName("http://serverresponder.ipv6call.ptszsoft.cz/", "ReceiverPort");
			WebServiceInterface hello = service.getPort(qname, WebServiceInterface.class);
			userList = hello.getMyUserList("jzeman");
			System.out.println("xxx"+userList.size());
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
			System.exit(0);
			
		}
		for (Integer i=0;i<userList.size();i++)
		{
			users.addElement(userList.getUser(i).toString());
		}
		/*for (User user : userList) {
			users.addElement(user.toString());
		}*/
		
		DefaultListModel<String> iamuser = new DefaultListModel<String>();
		iamuser.addElement("jzeman");

		panelL.add(new JLabel("From:"));
		JList<String> iamList = new JList<String>(iamuser);
		iamList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		iamList.setSelectedIndex(0);
		iamList.setVisibleRowCount(1);
		JScrollPane iamListScrollPanel = new JScrollPane(iamList);
		panelL.add(iamListScrollPanel);

		panelL.add(new JLabel("To:"));
		JList<String> usersList = new JList<String>(users);
		usersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		usersList.setSelectedIndex(0);
		usersList.setVisibleRowCount(3);
		JScrollPane usersListScrollPanel = new JScrollPane(usersList);
		panelL.add(usersListScrollPanel);

		JPanel panelRH = new JPanel();
		JTextArea comArrea = new JTextArea();
		comArrea.setSize(1000, 2000);
		comArrea.setEditable(false);
		comArrea.setText("TXT:");
		panelRH.add(comArrea);

		JPanel panelRD = new JPanel();
		panelRD.setLayout(new GridLayout(2, 1));
		JTextField message = new JTextField();
		// message.setSize(100,10);
		panelRD.add(message);
		JButton sendButton = new JButton("send");
		panelRD.add(sendButton);

		JPanel panelR = new JPanel();
		panelR.setLayout(new GridLayout(2, 1));
		panelR.add(panelRH);
		panelR.add(panelRD);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(panelL);
		panel.add(panelR);

		JFrame frame = new JFrame("IPv6call client");
		frame.add(panel);
		//frame.pack();
		frame.setLocation(100, 100);
		frame.setSize(300,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
