package com.example.tuwaiqproject02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Comment {
    @NotEmpty(message = "id is required")
    @Size(min = 3, message = "id have to be 3 character long")
    private String id;
    @NotEmpty(message = "id is required")
    @Size(min = 5, message = "id have to be 5 character long")
    private String userID;
    @NotEmpty(message = "id is required")
    @Size(min = 6, message = "id have to be 6 character long")
    private String message;
    @NotNull(message = "id is required")
    @Range(min = 1,max = 5, message = "id have to be 3 character long")
    private int rate;

}
