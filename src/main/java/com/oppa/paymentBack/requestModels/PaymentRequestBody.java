package com.oppa.paymentBack.requestModels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRequestBody {

    private double amount;

    private int mobile;

    private double commissionTax;

    private String personalNumber;
}
