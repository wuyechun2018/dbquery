package org.wuyechun.util.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class WsApp {
	
	public static void main(String[] args){
		
		InfoSearchServices server = new InfoSearchServices();
		ArrayOfString str=server.getInfoSearchServicesSoap().getInfo("2014818724", "卢茹", "340204197308011029");
		//server.get
		System.out.println("ok");
		

		
		 try {
			URL wsdlUrl = new URL("http://172.16.7.107:3164/InfoSearchServices.asmx?WSDL");
			 Service s = Service.create(wsdlUrl, new QName("http://tempuri.org/", "InfoSearchServices"));
			 InfoSearchServicesSoap hs = s.getPort(new QName("http://tempuri.org/", "InfoSearchServicesSoap"), InfoSearchServicesSoap.class);
			 ArrayOfString ret = hs.getInfo("2014818724", "卢茹", "340204197308011029");
			
		
			 System.out.println("ok-2");
		 
		 } catch (MalformedURLException e) {
			e.printStackTrace();
		}

		
		
	}

}
