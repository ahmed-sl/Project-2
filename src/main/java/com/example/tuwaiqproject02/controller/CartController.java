package com.example.tuwaiqproject02.controller;

import com.example.tuwaiqproject02.model.Cart;
import com.example.tuwaiqproject02.model.User;
import com.example.tuwaiqproject02.service.CartService;
import com.example.tuwaiqproject02.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    public final CartService cartService;

    @GetMapping
    public ResponseEntity<ArrayList<Cart>> getCart(){
        return ResponseEntity.status(200).body(cartService.getCarts());
    }
    @PostMapping
    public ResponseEntity<String> addCart(@RequestBody @Valid Cart cart,Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(cartService.addCart(cart));
    }

}
