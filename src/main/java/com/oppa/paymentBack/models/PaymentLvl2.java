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
@Table(name = "payment_l2")
public class PaymentLvl2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "personal_num")
    private String personalNumber;

    @JsonIgnore
    @JoinColumn(name = "l1_id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PaymentLvl1 lvl1;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "lvl2")
    private PaymentLvl3 lvl3;


    @Override
    public String toString() {
        if (lvl3 == null) {
            return " personalNumber='" + personalNumber + '\'';
        }
        return " personalNumber='" + personalNumber + '\'' + "," + lvl3;
    }
}
