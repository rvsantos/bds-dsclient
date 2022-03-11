package com.devsuperior.clientcrud.exceptions;

import java.time.Instant;

public class StandardError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    private StandardError(Instant timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public static class StandardErrorBuilder {
        private Instant timestamp;
        private Integer status;
        private String error;
        private String message;
        private String path;

        public StandardErrorBuilder timestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public StandardErrorBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public StandardErrorBuilder error(String error) {
            this.error = error;
            return this;
        }

        public StandardErrorBuilder message(String message) {
            this.message = message;
            return this;
        }

        public StandardErrorBuilder path(String path) {
            this.path = path;
            return this;
        }

        public StandardError build() {
            return new StandardError(timestamp, status, error, message, path);
        }
    }
}
