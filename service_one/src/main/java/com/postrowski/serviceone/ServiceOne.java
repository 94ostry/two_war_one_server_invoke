package com.postrowski.serviceone;

import com.postrowski.servicecommon.ServiceData;
import com.postrowski.servicecommon.ServiceOneIf;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Logger;

@Stateless
//@Local
@Remote(ServiceOneIf.class)
public class ServiceOne implements ServiceOneIf {

    private final Logger LOGGER = Logger.getLogger(ServiceOne.class.getName());

    @Override
    public String getSomething() {

        LOGGER.info("*************** ServiceOne#getSomething(-) method invoked.");

        return LocalDateTime.now().toString();
    }

    @Override
    public ServiceData getSomethingData() {
        LOGGER.info("*************** ServiceOne#getSomething(-) method invoked.");

        LocalDateTime time = LocalDateTime.now();
        String timestamp = time.toString();

        ServiceData serviceData = new ServiceData();
        serviceData.id = Long.valueOf(1);
        serviceData.dateTime = time;

        serviceData.data = new ArrayList<>();
        serviceData.data.add(timestamp);

        return serviceData;
    }
}
