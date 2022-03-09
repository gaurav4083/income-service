package com.nhs.springboot.incomeservice.model;

import com.nhs.springboot.incomeservice.annotation.AmountCheck;
import com.nhs.springboot.incomeservice.constant.Frequency;

@AmountCheck(
    frequency = "frequency",
    amount = "amount",
    message = "Invalid Amount! Not a whole number."
)
public class RegularAmount {
    private Frequency frequency;

    private String amount;

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RegularAmount{" +
            "frequency=" + frequency +
            ", amount='" + amount + '\'' +
            '}';
    }
}
