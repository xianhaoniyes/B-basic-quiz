package com.thoughtworks.gtb.myquiz.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {

    private LocalDateTime time;
    private HttpStatus httpStatus;
    private String error;
    private String message;

}
