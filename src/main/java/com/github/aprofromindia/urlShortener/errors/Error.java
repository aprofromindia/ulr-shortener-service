package com.github.aprofromindia.urlShortener.errors;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Error {
    GENERIC_ERROR(1000),
    ASYNC_ERROR(1001),
    REQ_BODY_ERROR(1002),
    MALFORMED_REQUEST(1003);

    @Getter(onMethod = @__(@JsonValue))
    private int code;

    Error(int code) {
        this.code = code;
    }
}
