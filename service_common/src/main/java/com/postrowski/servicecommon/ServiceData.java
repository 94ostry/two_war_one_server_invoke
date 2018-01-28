package com.postrowski.servicecommon;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class ServiceData implements Serializable {

    public Long id;
    public LocalDateTime dateTime;
    public List<String> data;
}
