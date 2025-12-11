package com.backend.global.rsData;

public record RsData<T>(String resultCode, String msg, Object data) {
}
