package com.oppa.paymentBack.repository;

import com.oppa.paymentBack.models.SendDataView;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SendDataViewRepository extends CrudRepository<SendDataView, Long> {

    List<SendDataView> findAll();
}
