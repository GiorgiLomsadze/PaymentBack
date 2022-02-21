package com.oppa.paymentBack.services;

import com.oppa.paymentBack.models.PaymentLvl1;
import com.oppa.paymentBack.models.PaymentLvl2;
import com.oppa.paymentBack.repository.PaymentLvl2Repository;
import com.oppa.paymentBack.requestModels.PaymentRequestBody;
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


@SpringBootTest(classes = PaymentLvl2Service.class)
class PaymentLvl2ServiceTest {

    @MockBean
    public PaymentLvl2Repository paymentLvl2Repository;

    @MockBean
    public TimeUtil timeUtil;

    @Autowired
    public PaymentLvl2Service underTest;

    private PaymentLvl2 paymentLvl2;
    private PaymentRequestBody paymentBody;
    private ServiceTypes serviceTypes;

    private final LocalDateTime localDateTime = LocalDateTime.now();

    @BeforeEach
    void setUp() {
        paymentBody =  PaymentRequestBody.builder()
                .amount(50)
                .mobile(598232525)
                .commissionTax(1)
                .personalNumber("010300425411")
                .build();

        paymentLvl2 = PaymentLvl2.builder()
                .personalNumber("010300425411")
                .lvl1(
                        PaymentLvl1.builder()
                                .amount(50)
                                .mobile(598232525)
                                .commissionTax(1)
                                .serviceId(2)
                                .isSent(false)
                                .transactionDate(localDateTime)
                                .build())
                .build();
        serviceTypes = ServiceTypes.charityService;
    }

    @Test
    void saveTransactionService() {
        //given
        when(timeUtil.getCurrentTime()).thenReturn(localDateTime);
        when(paymentLvl2Repository.save(paymentLvl2)).thenReturn(paymentLvl2);
        //when
        underTest.saveTransactionService(paymentBody, serviceTypes);
        //then
        verify(paymentLvl2Repository).save(paymentLvl2);
    }
}