package com.example.tuwaiqproject02.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@AllArgsConstructor @Data
public class Merchant {
    @NotEmpty(message = "id is required")
    @Size(min = 3, message = "id have to be 3 character long")
    private String id;
    @NotEmpty (message = "name is required")
    @Size(min = 3, message = "name have to be 3 character long")
    private String name;
}
