package com.oppa.paymentBack.services;


import com.oppa.paymentBack.models.SendDataView;
import com.oppa.paymentBack.repository.PaymentLvl1Repository;
import com.oppa.paymentBack.repository.SendDataViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SendDataViewService {
    private final SendDataViewRepository sendDataViewRepository;
    private final PaymentLvl1Repository paymentLvl1Repository;

    @Transactional
    public List<SendDataView> sendDataViews() {
        List<SendDataView> data = sendDataViewRepository.findAll();
        List<SendDataView> calculatedData = new ArrayList<>();
        int counter = 0;
        for (SendDataView val : data) {
            counter += val.getLength();
            if (counter <= 1000) {
                calculatedData.add(val);
                paymentLvl1Repository.updateDataById(val.getId());
            } else {
                break;
            }

        }

        return calculatedData;
    }
}
