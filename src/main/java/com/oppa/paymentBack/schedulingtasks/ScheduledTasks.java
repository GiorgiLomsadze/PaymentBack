package com.oppa.paymentBack.schedulingtasks;


import com.oppa.paymentBack.services.SendDataViewService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
@RequiredArgsConstructor
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public final SendDataViewService sendDataViewService;


    @Scheduled(fixedRate = 1620000)
    public void reportCurrentTime() {
        log.info("------------------------------------------------------");
        log.info("The given information was sent to the server...");
        sendDataViewService.sendDataViews().forEach(data -> log.info(data.toString()));
        log.info("------------------------------------------------------");
    }
}
