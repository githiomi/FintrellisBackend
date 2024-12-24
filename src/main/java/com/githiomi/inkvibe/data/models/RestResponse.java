package com.githiomi.inkvibe.data.models;

import com.githiomi.inkvibe.data.enums.ResponseType;

import java.time.LocalDateTime;

public class RestResponse<T> {
    T body;
    LocalDateTime timestamp;
    ResponseType responseType;

    public RestResponse(T body, ResponseType responseType) {
        this.body = body;
        this.responseType = responseType;
        this.timestamp = LocalDateTime.now();
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }
}

