package com.myntra.kuber.domain;

public enum CreditStatus {

    INIT("INIT"),
    SUCCESS("SUCCESS"),
    FAILED("FAILED"),
    PENDING("PENDING");

    private String text;

    CreditStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
