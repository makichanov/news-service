package com.makichanov.news.thirdparty.mediastack.error;

public class MediastackApiError extends RuntimeException {
    public MediastackApiError(String message) {
        super(message);
    }
}
