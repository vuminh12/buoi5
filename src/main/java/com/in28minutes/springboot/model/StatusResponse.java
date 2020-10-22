package com.in28minutes.springboot.model;

public class StatusResponse {
    private boolean success;

    public StatusResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
