package com.myntra.kuber.domain;

public enum CreditErrorCode {

    INIT("INIT"),
    SUCCESS("SUCCESS"),
    FAILED("FAILED"),
    PENDING("PENDING");

    private String text;

    CreditErrorCode(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
