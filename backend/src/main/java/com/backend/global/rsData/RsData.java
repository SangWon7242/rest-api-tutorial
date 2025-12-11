package com.backend.global.rsData;

public record RsData<T>(String resultCode, String msg, Object data) {
  public RsData(String resultCode, String formatted) {
    this(resultCode, formatted, null);
  }
}
