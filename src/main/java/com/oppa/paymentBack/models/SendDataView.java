package com.oppa.paymentBack.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "senddataview")
@Subselect("SELECT * FROM senddataview")
@Immutable
public class SendDataView {

    @Id
    private Integer id;

    private double amount;

    private int mobile;

    private LocalDateTime transaction_data;

    private int service_id;

    private double commission_tax;

    private String personal_num;

    private String acc_number;

    private Integer length;


    @Override
    public String toString() {
        return "* " +
                "id=" + id +
                ", amount=" + amount +
                ", mobile=" + mobile +
                ", transaction_data=" + transaction_data +
                ", service_id=" + service_id +
                ", commission_tax=" + commission_tax +
                ", personal_num='" + personal_num + '\'' +
                ", acc_number='" + acc_number + '\'';
    }
}
