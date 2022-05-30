package com.example.tuwaiqproject02.service;

import com.example.tuwaiqproject02.model.Cart;
import com.example.tuwaiqproject02.model.Product;
import com.example.tuwaiqproject02.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service @RequiredArgsConstructor
public class CartService {

    ArrayList<Cart> carts = new ArrayList<>();
    public final ProductService productService;
    public ArrayList<Cart> getCarts() {
        return carts;
    }
    public String addCart(Cart cart) {
        carts.add(cart);
        return "add cart";
    }
}
