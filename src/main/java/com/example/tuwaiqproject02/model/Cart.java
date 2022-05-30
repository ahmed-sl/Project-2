package com.example.tuwaiqproject02.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
//@AllArgsConstructor
public class Cart {
    @NotEmpty(message = "id is required")
    @Size(min = 3, message = "id have to be 3 character long")
    private String id;
    @NotEmpty (message = "userID is required")
    @Size(min = 3, message = "userID have to be 3 character long")
    private String userID;
    private ArrayList<Product> products;

    public Cart(String id, String userID, ArrayList<Product> products) {
        this.id = id;
        this.userID = userID;
        this.products = products;
    }
}
