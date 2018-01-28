package com.postrowski.servicetwo;

import com.postrowski.servicecommon.ServiceData;
import com.postrowski.servicecommon.ServiceOneIf;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@Path("foo")
@Stateless
public class FooEndpoint {

    //@EJB(lookup = "java:global/ServiceOne/ServiceOne!com.postrowski.servicecommon.ServiceOneIf")
    //@Inject
    //private ServiceOneIf serviceOne;


//    @GET
//    public Response get() {
//        return Response.ok(serviceOne.getSomething()).build();
//    }

    @Inject
    Client client;

    @GET
    public Response get() {
        return Response.ok(client.invoke()).build();
    }

    @GET
    @Path("data")
    public Response getData() {

        ServiceData serviceData = client.invokeData();

        return Response.ok(serviceData.dateTime.toString()).build();
    }

}
