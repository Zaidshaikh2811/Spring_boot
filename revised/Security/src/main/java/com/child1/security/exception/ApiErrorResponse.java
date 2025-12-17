package com.child1.security.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiErrorResponse {

    private boolean success = false;
    private int status;
    private String error;
    private String message;
    private String path;
    private LocalDateTime timestamp;
    private Map<String, String> details;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ApiErrorResponse(
            int status,
            String error,
            String message,
            String path,
            Map<String, String> details
    ) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    // getters
}