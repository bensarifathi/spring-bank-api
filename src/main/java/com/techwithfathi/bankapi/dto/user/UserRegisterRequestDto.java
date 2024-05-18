package com.techwithfathi.bankapi.dto.user;

public class UserRegisterRequestDto {
    private String username;
    private String password;

    public UserRegisterRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserRegisterRequestDto() {
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
}
