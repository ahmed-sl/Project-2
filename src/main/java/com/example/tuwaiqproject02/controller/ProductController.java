package com.example.tuwaiqproject02.controller;

import com.example.tuwaiqproject02.model.Comment;
import com.example.tuwaiqproject02.model.Product;
import com.example.tuwaiqproject02.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    public final ProductService productService;

    @GetMapping
    public ResponseEntity<ArrayList<Product>> getProduct(){
        return ResponseEntity.status(200).body(productService.getProduct());

    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductID(@PathVariable String id){

        return ResponseEntity.status(200).body(productService.getProductsID(id));

    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
          boolean isAdd=productService.addProduct(product);
        if(!isAdd){
            return ResponseEntity.status(500).body("some error in add !!");
        }
        return ResponseEntity.status(200).body("Product add !");

    }

    @PutMapping("/{index}")
    public ResponseEntity<String> editProduct(@PathVariable int index, @RequestBody @Valid Product product,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(productService.editProduct(index,product));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> deleteProduct(@PathVariable int index){
        return ResponseEntity.status(200).body(productService.deleteProduct(index));
    }

    @GetMapping("/comment/{productID}")
    public ResponseEntity<ArrayList<Comment>> getAllComment(@PathVariable String productID){
        return ResponseEntity.status(200).body(productService.getAllComment(productID));
    }
}
