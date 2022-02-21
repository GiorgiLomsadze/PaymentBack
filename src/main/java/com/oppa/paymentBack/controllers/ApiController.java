package com.oppa.paymentBack.controllers;


import com.oppa.paymentBack.models.PaymentLvl1;
import com.oppa.paymentBack.requestModels.MobileRequestBody;
import com.oppa.paymentBack.requestModels.PaymentL3RequestBody;
import com.oppa.paymentBack.requestModels.PaymentRequestBody;
import com.oppa.paymentBack.services.PaymentLvl1Service;
import com.oppa.paymentBack.services.PaymentLvl2Service;
import com.oppa.paymentBack.services.PaymentLvl3Service;
import com.oppa.paymentBack.utilities.ServiceTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("${api.base.path}")
public class ApiController {

    public final PaymentLvl1Service paymentLvl1Service;
    public final PaymentLvl2Service paymentLvl2Service;
    public final PaymentLvl3Service paymentLvl3Service;


    @GetMapping("/dataService")
    public List<PaymentLvl1> getPaymentsLvl1() {
        return paymentLvl1Service.getPaymentLvl1();
    }


    @PostMapping("/saveMobileService")
    public void saveMobileService(@RequestBody MobileRequestBody mobile) {
        paymentLvl1Service.saveMobileServiceData(mobile, ServiceTypes.MobileService);
    }

    @PostMapping("/saveCharityService")
    public void savecharityService(@RequestBody PaymentRequestBody pay) {
        paymentLvl2Service.saveTransactionService(pay, ServiceTypes.charityService);
    }

    @PostMapping("/saveUtilitiesService")
    public void saveUtilitiesService(@RequestBody PaymentRequestBody pay) {
        paymentLvl2Service.saveTransactionService(pay, ServiceTypes.UtilitiesService);
    }

    @PostMapping("/saveFinancialService")
    public void saveFinancialService(@RequestBody PaymentL3RequestBody pay) {
        paymentLvl3Service.saveFinancialService(pay, ServiceTypes.FinancialService);
    }
}
