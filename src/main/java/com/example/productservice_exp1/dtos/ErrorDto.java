package com.example.productservice_exp1.dtos;


import com.example.productservice_exp1.exceptions.ProductNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Getter
@Setter
public class ErrorDto {

String message;

}
