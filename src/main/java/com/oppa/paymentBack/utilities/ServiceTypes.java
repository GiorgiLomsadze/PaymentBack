package com.oppa.paymentBack.utilities;

import lombok.Getter;

@Getter
public enum ServiceTypes {
    MobileService(1),
    charityService(2),
    UtilitiesService(3),
    FinancialService(4);

    private final int serviceId;

    ServiceTypes(int serviceId) {
        this.serviceId = serviceId;
    }
}
