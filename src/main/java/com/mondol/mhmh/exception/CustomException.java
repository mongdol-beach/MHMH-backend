package com.mondol.mhmh.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {
    private final String message; // 에러 메시지
    private final HttpStatus statusCode; // HTTP 상태 코드

    // 기본 생성자 (상태 코드 없이)
    public CustomException(String message) {
        super(message);
        this.message = message;
        this.statusCode = HttpStatus.BAD_REQUEST; // 기본적으로 500 에러로 설정
    }

    // 상태 코드와 메시지를 받는 생성자
    public CustomException(String message, HttpStatus statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }

    // 예외와 함께 메시지를 받는 생성자
    public CustomException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.statusCode = HttpStatus.BAD_REQUEST; // 기본적으로 500 에러로 설정
    }

    // 상태 코드, 메시지, 예외를 받는 생성자
    public CustomException(String message, HttpStatus statusCode, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.statusCode = statusCode;
    }

    public CustomException(HttpStatus httpStatus, String message) {
        super(message);
        this.message = message;
        this.statusCode = httpStatus;
    }
}
