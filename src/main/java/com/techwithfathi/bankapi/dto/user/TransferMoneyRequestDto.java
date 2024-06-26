package com.techwithfathi.bankapi.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferMoneyRequestDto {
    private String username;
    private String password;
    @JsonProperty("To")
    private String to;
    private int amount;

    public TransferMoneyRequestDto() {
    }

    public TransferMoneyRequestDto(String username, String password, String to, int amount) {
        this.username = username;
        this.password = password;
        this.to = to;
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransferMoneyRequestDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", To='" + to + '\'' +
                ", amount=" + amount +
                '}';
    }
}
