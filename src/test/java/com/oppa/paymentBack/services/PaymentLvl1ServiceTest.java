package com.oppa.paymentBack.services;

import com.oppa.paymentBack.models.PaymentLvl1;
import com.oppa.paymentBack.repository.PaymentLvl1Repository;
import com.oppa.paymentBack.requestModels.MobileRequestBody;
import com.oppa.paymentBack.utilities.ServiceTypes;
import com.oppa.paymentBack.utilities.TimeUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = PaymentLvl1Service.class)
class PaymentLvl1ServiceTest {

    @MockBean
    public PaymentLvl1Repository paymentLvl1Repository;

    @MockBean
    public TimeUtil timeUtil;

    @Autowired
    public PaymentLvl1Service underTest;

    private PaymentLvl1 paymentLvl1, paymentLvl1V2, paymentLvl1V3;
    private MobileRequestBody mobileBody;
    private ServiceTypes serviceTypes;

    private final LocalDateTime localDateTime = LocalDateTime.now();

    @BeforeEach
    void setUp(){
        mobileBody = MobileRequestBody.builder()
                .amount(50)
                .mobile(598232525)
                .commissionTax(1)
                .build();

        paymentLvl1 = PaymentLvl1.builder()
                .amount(50)
                .mobile(598232525)
                .commissionTax(1)
                .serviceId(1)
                .isSent(false)
                .transactionDate(localDateTime)
                .build();

        paymentLvl1V2 = PaymentLvl1.builder()
                .amount(150)
                .mobile(599252525)
                .commissionTax(2)
                .serviceId(1)
                .isSent(false)
                .transactionDate(localDateTime)
                .build();

        paymentLvl1V3 = PaymentLvl1.builder()
                .amount(200)
                .mobile(599252323)
                .commissionTax(2.5)
                .serviceId(1)
                .isSent(false)
                .transactionDate(localDateTime)
                .build();



        serviceTypes = ServiceTypes.MobileService;
    }


    @Test
    void getPaymentLvl1_checkDatabaseCall() {
        //given
        when(paymentLvl1Repository.findAll()).thenReturn(List.of());
        //when
        underTest.getPaymentLvl1();
        //then
        verify(paymentLvl1Repository).findAll();
    }

    @Test
    void getPaymentLvl1_checkResult() {
        //given
        List<PaymentLvl1> payments = List.of(paymentLvl1, paymentLvl1V2, paymentLvl1V3);
        when(paymentLvl1Repository.findAll()).thenReturn(payments);
        //when
        List<PaymentLvl1> paymentLvl1Result = underTest.getPaymentLvl1();
        //then
        assertThat(paymentLvl1Result).isEqualTo(payments);
    }

    @Test
    void saveMobileServiceData() {
        //given
        when(timeUtil.getCurrentTime()).thenReturn(localDateTime);
        when(paymentLvl1Repository.save(paymentLvl1)).thenReturn(paymentLvl1);
        //when
        underTest.saveMobileServiceData(mobileBody, serviceTypes);
        //then
        verify(paymentLvl1Repository).save(paymentLvl1);
    }
}