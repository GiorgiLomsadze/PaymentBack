package com.oppa.paymentBack.utilities;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimeUtil {

    public LocalDateTime getCurrentTime(){
        return LocalDateTime.now();
    }
}
