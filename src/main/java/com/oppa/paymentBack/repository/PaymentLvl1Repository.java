package com.oppa.paymentBack.repository;

import com.oppa.paymentBack.models.PaymentLvl1;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaymentLvl1Repository extends CrudRepository<PaymentLvl1, Long> {

    List<PaymentLvl1> findAll();

    @Modifying
    @Query(value = "update payment_l1 pay set pay.is_sent = true where pay.id = :idVal ",nativeQuery = true)
    void updateDataById(Integer idVal);
}
