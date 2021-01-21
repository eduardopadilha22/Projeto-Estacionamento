package com.itriad.apiestacionamento.exceptions;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    public RestResponseEntityExceptionHandler() {
        super();
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<ErrorResponse> handleBadRequestConstraintViolation(final ConstraintViolationException ex,
                                                                             final WebRequest request) {
        return generatedError(ex.getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<ErrorResponse> handleBadRequestDataIntegrityViolation(
            final DataIntegrityViolationException ex, final WebRequest request) {
        return generatedError(ex.getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(value = { RuntimeException.class })
    public ResponseEntity<ErrorResponse> handleBadRequestEntity(final RuntimeException ex, final WebRequest request) {
        return generatedError(ex.getMessage(), HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
                                                                  final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        String bodyOfResponse = "This should be application specific";

        if( ex.getCause() instanceof JsonMappingException)
            bodyOfResponse = ex.getMessage();
        else if ( ex.getCause() instanceof JsonParseException)
            bodyOfResponse = ex.getMessage();

        return handleExceptionInternal(ex, bodyOfResponse, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
                                                                  final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        //final String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, ex.getMessage(), headers, HttpStatus.BAD_REQUEST, request);
    }

    // 403
    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(final Exception ex, final WebRequest request) {
        return generatedError(ex.getMessage(), HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.value());
    }

    // 404

    @ExceptionHandler(value = { EntityNotFoundException.class })
    protected ResponseEntity<ErrorResponse> handleNotFound(final RuntimeException ex, final WebRequest request) {
        return generatedError(ex.getMessage(), HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value());
    }


    // 409

    @ExceptionHandler({ InvalidDataAccessApiUsageException.class, DataAccessException.class })
    protected ResponseEntity<ErrorResponse> handleConflict(final RuntimeException ex, final WebRequest request) {
        return generatedError(ex.getMessage(), HttpStatus.CONFLICT, HttpStatus.CONFLICT.value());
    }

    // 412

    // 500

    @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class,
            TransactionSystemException.class})
    public ResponseEntity<ErrorResponse> handleInternal(final RuntimeException ex, final WebRequest request) {
        logger.error("500 Status Code", ex);

        return generatedError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR.value());
    }




    private ResponseEntity<ErrorResponse> generatedError(String message, HttpStatus http, int httpStatusValue) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(httpStatusValue);
        error.setMessage(message);
        return new ResponseEntity<ErrorResponse>(error, http);
    }
}
