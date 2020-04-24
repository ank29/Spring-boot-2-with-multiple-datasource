package com.myntra.kuber.domain;

public enum CreditState {

    INIT("INIT"),
    SUCCESS("SUCCESS"),
    FAILED("FAILED"),
    PENDING("PENDING");

    private String text;

    CreditState(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
