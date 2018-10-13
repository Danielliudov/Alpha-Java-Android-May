package com.telerikacademy.springhibernatedemo.models;

public class AddressDTO {
    private String AddressText;

    public AddressDTO(String addressText) {
        AddressText = addressText;
    }

    public String getAddressText() {
        return AddressText;
    }

    public void setAddressText(String addressText) {
        AddressText = addressText;
    }
}
