package com.oppa.paymentBack.repository;

import com.oppa.paymentBack.models.PaymentLvl3;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentLvl3Repository extends CrudRepository<PaymentLvl3, Long> {

}
