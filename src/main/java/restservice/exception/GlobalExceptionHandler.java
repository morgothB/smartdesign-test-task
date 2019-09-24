package restservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import restservice.json.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {javax.transaction.NotSupportedException.class, javax.transaction.SystemException.class})
    public ResponseEntity handleTransactionExceptions(Exception ex, WebRequest request) {
        ExceptionResponse body = new ExceptionResponse(System.currentTimeMillis(), 500, "Something has gone wrong while processing query: " + ex.getLocalizedMessage());
        return handleExceptionInternal(ex, body, HttpHeaders.EMPTY, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

}
