package com.myntra.kuber.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="credit_transaction_log")
public class CreditLog extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="pps_id")
    protected String ppsId;

    @Column(name="pps_transaction_id")
    protected String ppsTransactionId;

    @Column(name="bank_account_id")
    protected long bankAccountId;

    @Column(name="amount")
    protected double amount;

    @Column(name="status")
    protected String status;

    @Column(name="error_code")
    protected String errorCode;

    @Column(name = "credit_transaction_id")
    private String creditTransactionId;

    @Column(name="state")
    protected String state;

    @Column(name="order_id")
    protected String orderId;

    @Column(name="uidx")
    protected String uidx;

    @Column(name="return_id")
    protected String returnId;

}
