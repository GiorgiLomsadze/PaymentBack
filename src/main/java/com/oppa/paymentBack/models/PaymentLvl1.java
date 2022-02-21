package com.oppa.paymentBack.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_l1")
public class PaymentLvl1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "mobile")
    private int mobile;

    @Column(name = "commission_tax")
    private double commissionTax;

    @Column(name = "service_id")
    private int serviceId;

    @Column(name = "is_sent")
    private boolean isSent;

    @Column(name = "transaction_data")
    private LocalDateTime transactionDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "lvl1")
    private PaymentLvl2 lvl2;
}
