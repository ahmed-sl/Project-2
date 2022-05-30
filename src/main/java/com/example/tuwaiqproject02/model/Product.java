package com.example.tuwaiqproject02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Product {
    @NotEmpty (message = "id is required")
    @Size(min = 3, message = "id have to be 3 character long")
    private String id;
    @NotEmpty (message = "name is required")
    @Size(min = 3, message = "name have to be 3 character long")
    private String name;
    @NotNull (message = "price is required")
    @Positive
    private int price;
    @NotEmpty (message = "categoryID is required")
    @Size(min = 3, message = "categoryID have to be 3 character long")
    private String categoryID;
    private ArrayList<Comment> comment;

    public Product(String id, String name, int price, String categoryID) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryID = categoryID;
        this.comment = new ArrayList<Comment>();
    }
}
