package com.oppa.paymentBack.repository;

import com.oppa.paymentBack.models.PaymentLvl2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentLvl2Repository extends CrudRepository<PaymentLvl2, Long> {

}
