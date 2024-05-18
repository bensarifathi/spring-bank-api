package com.techwithfathi.bankapi.dto.user;

public class UserBalanceResponseDto {
    private String username;
    private int own;
    private int debt;

    public UserBalanceResponseDto() {
    }

    public UserBalanceResponseDto(String username, int amount, int debt) {
        this.username = username;
        this.own = amount;
        this.debt = debt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getOwn() {
        return own;
    }

    public void setOwn(int own) {
        this.own = own;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }
}
