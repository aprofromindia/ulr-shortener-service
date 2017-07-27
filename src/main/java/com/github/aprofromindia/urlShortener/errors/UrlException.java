package com.github.aprofromindia.urlShortener.errors;

public class UrlException extends RuntimeException {
    private static final long serialVersionUID = -4721021569957101020L;
    private Error code;

    public UrlException(Error code, String msg) {
        super(msg);
        this.code = code;
    }
}
