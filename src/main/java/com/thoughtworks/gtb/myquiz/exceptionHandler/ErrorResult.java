package com.thoughtworks.gtb.myquiz.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {

    private LocalDateTime timestamp;
    private HttpStatus error;
    private Integer status;
    private String message;

}
