package com.techwithfathi.bankapi.dto.user;

public class AddMoneyRequestDto {
    private String username;
    private String password;
    private int amount;

    public AddMoneyRequestDto() {
    }

    public AddMoneyRequestDto(String username, String password, int amount) {
        this.username = username;
        this.password = password;
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAmount() {
        return amount;
    }
}
