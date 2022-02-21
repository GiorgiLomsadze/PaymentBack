package com.oppa.paymentBack.services;


import com.oppa.paymentBack.models.PaymentLvl1;
import com.oppa.paymentBack.models.PaymentLvl2;
import com.oppa.paymentBack.models.PaymentLvl3;
import com.oppa.paymentBack.repository.PaymentLvl3Repository;
import com.oppa.paymentBack.requestModels.PaymentL3RequestBody;
import com.oppa.paymentBack.utilities.ServiceTypes;
import com.oppa.paymentBack.utilities.TimeUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = PaymentLvl3Service.class)
class PaymentLvl3ServiceTest {

    @MockBean
    public PaymentLvl3Repository paymentLvl3Repository;

    @MockBean
    public TimeUtil timeUtil;

    @Autowired
    public PaymentLvl3Service underTest;

    private PaymentLvl3 payment;
    private PaymentL3RequestBody paymentBody;
    private ServiceTypes serviceTypes;

    private final LocalDateTime localDateTime = LocalDateTime.now();

    @BeforeEach
    void setUp() {
        paymentBody = PaymentL3RequestBody.builder()
                .amount(50)
                .mobile(598232525)
                .commissionTax(1)
                .personalNumber("010300425411")
                .accNumber("GE00XX0000000000000128")
                .build();

        payment = PaymentLvl3.builder()
                .accNumber("GE00XX0000000000000128")
                .lvl2(
                        PaymentLvl2.builder()
                                .personalNumber("010300425411")
                                .lvl1(PaymentLvl1.builder()
                                        .amount(50)
                                        .mobile(598232525)
                                        .commissionTax(1)
                                        .serviceId(4)
                                        .isSent(false)
                                        .transactionDate(localDateTime)
                                        .build())
                                .build())
                .build();
        serviceTypes = ServiceTypes.FinancialService;
    }

    @Test
    void saveFinancialService() {
        //given
        when(timeUtil.getCurrentTime()).thenReturn(localDateTime);
        when(paymentLvl3Repository.save(payment)).thenReturn(payment);
        //when
        underTest.saveFinancialService(paymentBody, serviceTypes);
        //then
        verify(paymentLvl3Repository).save(payment);
    }
}