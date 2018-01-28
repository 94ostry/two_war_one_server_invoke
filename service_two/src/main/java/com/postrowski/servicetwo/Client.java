package com.postrowski.servicetwo;

import com.postrowski.servicecommon.ServiceData;
import com.postrowski.servicecommon.ServiceOneIf;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.logging.Logger;

@Stateless
public class Client {
	private final Logger LOGGER = Logger.getLogger(Client.class.getName());

	@EJB( lookup = "java:global/ServiceOne/ServiceOne!com.postrowski.servicecommon.ServiceOneIf" )
	ServiceOneIf service;

	public String invoke() {
		LOGGER.info("CLIENT INVOKED");

		//ServiceOneIf service = lookup();
		
		System.out.println(service);
		
		return service.getSomething();
	}

	public ServiceData invokeData() {
		LOGGER.info("CLIENT INVOKED");

		//ServiceOneIf service = lookup();

		System.out.println(service);

		return service.getSomethingData();
	}

	private ServiceOneIf lookup()
	{
		try {
			Context ctx = new InitialContext();
			Object bean = ctx.lookup("java:global/ServiceOne/ServiceOne!com.postrowski.servicecommon.ServiceOneIf");

			ServiceOneIf service = (ServiceOneIf)bean;

			return service;

		} catch (Exception e) {

			e.printStackTrace();

			LOGGER.warning("Error");

		}

		return null;

	}
}