package com.oppa.paymentBack.services;

import com.oppa.paymentBack.models.PaymentLvl1;
import com.oppa.paymentBack.models.PaymentLvl2;
import com.oppa.paymentBack.repository.PaymentLvl2Repository;
import com.oppa.paymentBack.requestModels.PaymentRequestBody;
import com.oppa.paymentBack.utilities.ServiceTypes;
import com.oppa.paymentBack.utilities.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentLvl2Service {

    public final PaymentLvl2Repository paymentLvl2Repository;
    private final TimeUtil timeUtil;


    @Transactional
    public void saveTransactionService(PaymentRequestBody charity, ServiceTypes serviceTypes) {
        PaymentLvl2 payment = PaymentLvl2.builder()
                .personalNumber(charity.getPersonalNumber())
                .lvl1(
                        PaymentLvl1.builder()
                                .amount(charity.getAmount())
                                .mobile(charity.getMobile())
                                .commissionTax(charity.getCommissionTax())
                                .serviceId(serviceTypes.getServiceId())
                                .isSent(false)
                                .transactionDate(timeUtil.getCurrentTime())
                                .build())
                .build();

        paymentLvl2Repository.save(payment);
    }
}
