package com.oppa.paymentBack.services;


import com.oppa.paymentBack.models.PaymentLvl1;
import com.oppa.paymentBack.repository.PaymentLvl1Repository;
import com.oppa.paymentBack.requestModels.MobileRequestBody;
import com.oppa.paymentBack.utilities.ServiceTypes;
import com.oppa.paymentBack.utilities.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PaymentLvl1Service {

    private final PaymentLvl1Repository paymentLvl1Repository;
    private final TimeUtil timeUtil;

    public List<PaymentLvl1> getPaymentLvl1() {
        return paymentLvl1Repository.findAll();
    }

    @Transactional
    public void saveMobileServiceData(MobileRequestBody mobile, ServiceTypes serviceTypes) {
        PaymentLvl1 payment = PaymentLvl1.builder()
                .amount(mobile.getAmount())
                .mobile(mobile.getMobile())
                .commissionTax(mobile.getCommissionTax())
                .serviceId(serviceTypes.getServiceId())
                .isSent(false)
                .transactionDate(timeUtil.getCurrentTime())
                .build();

        paymentLvl1Repository.save(payment);
    }
}
