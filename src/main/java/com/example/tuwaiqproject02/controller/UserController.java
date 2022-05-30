package com.example.tuwaiqproject02.controller;

import com.example.tuwaiqproject02.model.Cart;
import com.example.tuwaiqproject02.model.Comment;
import com.example.tuwaiqproject02.model.Product;
import com.example.tuwaiqproject02.model.User;
import com.example.tuwaiqproject02.service.ProductService;
import com.example.tuwaiqproject02.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @GetMapping
    public ResponseEntity<ArrayList<User>> getUser(){
        return ResponseEntity.status(200).body(userService.getUser());

    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
          boolean isAdd=userService.addUser(user);
        if(!isAdd){
            return ResponseEntity.status(500).body("some error in add !!");
        }
        return ResponseEntity.status(200).body("User add !");

    }

    @PutMapping("/{index}")
    public ResponseEntity<String> editUser(@PathVariable int index, @RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(userService.editUser(index,user));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> deleteUser(@PathVariable int index){
        return ResponseEntity.status(200).body(userService.deleteUser(index));
    }

    @PostMapping("/{userID}/{productID}")
    public ResponseEntity<String> addProductToCart(@PathVariable String userID, @PathVariable String productID){
        int isAddProductToCart = userService.addProductToCart(userID,productID);
        return switch (isAddProductToCart) {
            case -1 -> ResponseEntity.status(400).body("userID is wrong");
            case 0 -> ResponseEntity.status(400).body("ProductID is wrong");
            case 1 -> ResponseEntity.status(200).body("Product add to cart");
            default -> ResponseEntity.status(500).body("Server error in add product to cart");
        };
    }
    @DeleteMapping("/{userID}/{productID}")
    public ResponseEntity<String> deleteProductToCart(@PathVariable String userID, @PathVariable String productID){
        int isDeleteProductToCart = userService.deleteProductToCart(userID,productID);
        return switch (isDeleteProductToCart) {
            case -1 -> ResponseEntity.status(400).body("userID is wrong");
            case 0 -> ResponseEntity.status(400).body("ProductID is wrong");
            case 1 -> ResponseEntity.status(400).body("cart is empty");
            case 2 -> ResponseEntity.status(200).body("Product remove from cart");
            default -> ResponseEntity.status(500).body("Server error in add product to cart");
        };
    }
    @PutMapping("/{userID}/{productID}/{merchantStockID}")
    public ResponseEntity<String> buyProduct(@PathVariable String userID, @PathVariable String productID, @PathVariable String merchantStockID){
        int isBuyProduct = userService.buyProduct(userID,productID,merchantStockID);
        return switch (isBuyProduct) {
            case -2 -> ResponseEntity.status(400).body("Merchant stock id is wrong");
            case -1 -> ResponseEntity.status(400).body("Product id is wrong");
            case 0 -> ResponseEntity.status(200).body("Buy product completed");
            case 1 -> ResponseEntity.status(400).body("you don't have enough money");
            case 2 -> ResponseEntity.status(400).body("User id is wrong");
            default -> ResponseEntity.status(500).body("server error");
        };
    }

    @PutMapping
    public ResponseEntity<String> buyProductCart(@RequestBody @Valid Cart cart){
        int isBuyProductCart = userService.buyProductCart(cart);
        return switch (isBuyProductCart) {
            case -1 -> ResponseEntity.status(400).body("User id is wrong");
            case 0 -> ResponseEntity.status(400).body("Product id is wrong");
            case 1 -> ResponseEntity.status(400).body("Product is finish");
            case 2 -> ResponseEntity.status(200).body("Buy product completed");
            default -> ResponseEntity.status(500).body("server error");
        };
    }

    @PostMapping("/commint/{userID}/{productID}")
    public ResponseEntity<Object> addComment(@PathVariable String userID, @PathVariable String productID,
                                             @RequestBody @Valid Comment comment,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        int isAddComment = userService.addComment(userID,productID,comment);

        return switch (isAddComment) {
            case -1 -> ResponseEntity.status(400).body("User id is wrong");
            case 0 -> ResponseEntity.status(200).body("Add comment completed");
            case 1 -> ResponseEntity.status(400).body("Product id is wrong");
            default -> ResponseEntity.status(500).body("server error");
        };
    }
}
