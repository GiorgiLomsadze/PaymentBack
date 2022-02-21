package com.oppa.paymentBack.services;


import com.oppa.paymentBack.models.PaymentLvl1;
import com.oppa.paymentBack.models.PaymentLvl2;
import com.oppa.paymentBack.models.PaymentLvl3;
import com.oppa.paymentBack.repository.PaymentLvl3Repository;
import com.oppa.paymentBack.requestModels.PaymentL3RequestBody;
import com.oppa.paymentBack.utilities.ServiceTypes;
import com.oppa.paymentBack.utilities.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentLvl3Service {

    public final PaymentLvl3Repository paymentLvl3Repository;
    private final TimeUtil timeUtil;


    @Transactional
    public void saveFinancialService(PaymentL3RequestBody financial, ServiceTypes serviceTypes) {

        PaymentLvl3 payment = PaymentLvl3.builder()
                .accNumber(financial.getAccNumber())
                .lvl2(
                        PaymentLvl2.builder()
                                .personalNumber(financial.getPersonalNumber())
                                .lvl1(PaymentLvl1.builder()
                                        .amount(financial.getAmount())
                                        .mobile(financial.getMobile())
                                        .commissionTax(financial.getCommissionTax())
                                        .serviceId(serviceTypes.getServiceId())
                                        .isSent(false)
                                        .transactionDate(timeUtil.getCurrentTime())
                                        .build())
                                .build())
                .build();

        paymentLvl3Repository.save(payment);
    }
}
