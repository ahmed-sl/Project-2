package com.example.tuwaiqproject02.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class PurchaseHistory {
    @NotEmpty(message = "id is required")
    @Size(min = 3, message = "id have to be 3 character long")
    private String id;
    @NotEmpty(message = "userID is required")
    @Size(min = 3, message = "userID have to be 3 character long")
    private String userID;
    @NotEmpty(message = "product is required")
    @Size(min = 3, message = "product have to be 3 character long")
    private String product;
    @NotEmpty(message = "price is required")
    @Size(min = 3, message = "price have to be 3 character long")
    private int price;

}
