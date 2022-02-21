package com.oppa.paymentBack.services;

import com.oppa.paymentBack.models.SendDataView;
import com.oppa.paymentBack.repository.PaymentLvl1Repository;
import com.oppa.paymentBack.repository.SendDataViewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.*;


@SpringBootTest(classes = SendDataViewService.class)
class SendDataViewServiceTest {

    @MockBean
    public  SendDataViewRepository sendDataViewRepository;

    @MockBean
    public  PaymentLvl1Repository paymentLvl1Repository;

    @Autowired
    public SendDataViewService underTest;

    private  SendDataView sendDataView1, sendDataView2, sendDataView3;


    @BeforeEach
    void setUp() {
        sendDataView1 = SendDataView.builder().id(5).length(450).build();
        sendDataView2 = SendDataView.builder().id(6).length(500).build();
        sendDataView3 = SendDataView.builder().id(7).length(550).build();
    }


    @Test
    void sendDataViews_EmptyData() {
        //given
        List<SendDataView> data = List.of();
        when(sendDataViewRepository.findAll()).thenReturn(data);
        doNothing().when(paymentLvl1Repository).updateDataById(any());
        //when
        underTest.sendDataViews();
        //then
        verify(paymentLvl1Repository,times(0)).updateDataById(any());
    }

    @Test
    void sendDataViews() {
        //given
        List<SendDataView> data = List.of(sendDataView1, sendDataView2, sendDataView3);
        when(sendDataViewRepository.findAll()).thenReturn(data);
        doNothing().when(paymentLvl1Repository).updateDataById(sendDataView1.getId());
        doNothing().when(paymentLvl1Repository).updateDataById(sendDataView2.getId());
        doNothing().when(paymentLvl1Repository).updateDataById(sendDataView3.getId());
        //when
        underTest.sendDataViews();
        //then
        verify(paymentLvl1Repository).updateDataById(sendDataView1.getId());
        verify(paymentLvl1Repository).updateDataById(sendDataView2.getId());
        verify(paymentLvl1Repository,times(0)).updateDataById(sendDataView3.getId());
    }
}