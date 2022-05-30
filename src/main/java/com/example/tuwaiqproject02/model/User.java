package com.example.tuwaiqproject02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class User {
    @NotEmpty(message = "id is required")
    @Size(min = 3, message = "id have to be 3 character long")
    private String id;
    @NotEmpty(message = "user name is required")
    @Size(min = 3, message = "user name have to be 3 character long")
    private String userName;
    @NotEmpty(message = "password is required")
//    @Pattern(regexp =  "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[!@#&()–[{}]:;',?/*~$^+=<>]).{6,20}$",
//            message = "password have to be 3 character long")
    private String password;
    @NotEmpty (message = "email is required")
    @Email (message = "email must be valid")
    private String email;
    @NotEmpty (message = "role is required")
    @Pattern(regexp = "(?i)(Admin|Customer)")
    private String role;
    @NotNull(message = "balance is required")
    @Positive (message = "balance must be positive")
    private int balance;
}
