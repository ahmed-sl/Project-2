package com.example.tuwaiqproject02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class MerchantStock {
    @NotEmpty(message = "id is required")
    @Size(min = 3, message = "id have to be 3 character long")
    private String id;
    @NotEmpty (message = "productID is required")
    @Size(min = 3, message = "productID have to be 3 character long")
    private String productID;
    @NotEmpty (message = "merchantID is required")
    @Size(min = 3, message = "merchantID have to be 3 character long")
    private String merchantID;
    @NotNull(message = "stock is required")
    @Range(min = 10, message = "stock have to be 10 ")
    private int stock;
}
