package br.com.vitorhugo.config;


/**
 *
 * @author alexandre
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<br.com.vitorhugo.config.ErrorResponse> handleAllExceptions(Exception ex) {
        
        // Convert stack trace utility to String
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        String stackTraceAsString = ""; //stringWriter.toString();

        br.com.vitorhugo.config.ErrorResponse error = new br.com.vitorhugo.config.ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            stackTraceAsString, // Send stacktrace to response body
            System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}


