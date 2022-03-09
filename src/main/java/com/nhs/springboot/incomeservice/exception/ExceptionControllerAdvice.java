package com.nhs.springboot.incomeservice.exception;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception Handling advice.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    /**
     * Handling of generic exceptions.
     *
     * @return ResponseEntity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleServerException(Exception e) {
        log.error(format("handleServerException %s", e.getMessage()));
        return new ResponseEntity<>(
            buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage()),
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * MethodArgumentNotValidException handling mechanism
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {

        log.error(format("handleServiceExceptionBadInput %s", ex.getMessage()));
        String errorMsgReceived = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResponseEntity<>(buildErrorResponse(HttpStatus.BAD_REQUEST, errorMsgReceived),
            HttpStatus.BAD_REQUEST);
    }

    /**
     * Build Error Response
     *
     * @param status
     * @param message
     * @return
     */
    private ErrorResponse buildErrorResponse(HttpStatus status, String message) {
        ErrorResponse errorResponse = new ErrorResponse();
        Error error = new Error(status, message);
        List<Error> errors = new ArrayList<>();
        errors.add(error);
        errorResponse.setErrors(errors);

        return errorResponse;
    }
}
