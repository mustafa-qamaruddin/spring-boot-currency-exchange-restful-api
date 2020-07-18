package com.apress.messaging.domain;

public class CurrencyConversion {
    
    private String base;
    private String code;
    private float amount;
    private float total;

    public CurrencyConversion(){}

    public CurrencyConversion(
        String base,
        String code,
        float amount,
        float total
    ) {
        super();
        this.base = base;
        this.code = code;
        this.amount = amount;
        this.total = total;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getBase() {
        return this.base;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}