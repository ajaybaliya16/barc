package com.test_core.thingsboard.customException;

import java.util.List;

import com.test_core.thingsboard.common.ThingsboardErrorCode;

public class ThingsboardException extends Exception {
	private static final long serialVersionUID = 1L;

    private ThingsboardErrorCode errorCode;
    private List<String> errors;

    public ThingsboardException() {
        super();
    }

    public ThingsboardException(ThingsboardErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ThingsboardException(String message, ThingsboardErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ThingsboardException(String message, Throwable cause, ThingsboardErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ThingsboardException(Throwable cause, ThingsboardErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ThingsboardErrorCode getErrorCode() {
        return errorCode;
    }


    public ThingsboardException(List<String> errors, ThingsboardErrorCode errorCode) {
        this.errors = errors;
        this.errorCode = errorCode;
    }

    public ThingsboardException(List<String> errors) {
        super("Validation errors: {} ");
        this.errors = errors;
        this.errorCode = ThingsboardErrorCode.BAD_REQUEST_PARAMS;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String getMessage() {
        if (errors == null || errors.isEmpty())
            return super.getMessage();
        StringBuilder sb = new StringBuilder(super.getMessage());
        for (String error : errors) {
            sb.append("\n").append(error);
        }
        return sb.toString();
    }
}
