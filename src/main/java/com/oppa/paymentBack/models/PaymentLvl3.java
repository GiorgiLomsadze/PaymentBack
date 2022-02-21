package com.oppa.paymentBack.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_l3")
public class PaymentLvl3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "acc_number")
    private String accNumber;

    @JsonIgnore
    @JoinColumn(name = "l2_id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PaymentLvl2 lvl2;


    @Override
    public String toString() {
        return " accNumber='" + accNumber + '\'';
    }
}
