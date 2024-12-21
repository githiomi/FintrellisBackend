package com.githiomi.inkvibe.data.enums;

public enum ResponseType {
    EXCEPTION("Exception"),
    DATA_RESPONSE("Data Response");

    private final String responseType;

    ResponseType(String responseType) {
        this.responseType = responseType;
    }

    private String getResponseType() {
        return this.responseType;
    }
}
