package com.oppa.paymentBack.requestModels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MobileRequestBody {

    private double amount;

    private int mobile;

    private double commissionTax;
}
