package com.example.tuwaiqproject02.controller;

import com.example.tuwaiqproject02.model.Category;
import com.example.tuwaiqproject02.model.Product;
import com.example.tuwaiqproject02.service.CategoryService;
import com.example.tuwaiqproject02.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    public final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ArrayList<Category>> getCategory(){
        return ResponseEntity.status(200).body(categoryService.getCategory());

    }

    @PostMapping
    public ResponseEntity<String> addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
          boolean isAdd=categoryService.addCategory(category);
        if(!isAdd){
            return ResponseEntity.status(500).body("some error in add !!");
        }
        return ResponseEntity.status(200).body("Product add !");

    }

    @PutMapping("/{index}")
    public ResponseEntity<String> editCategory(@PathVariable int index, @RequestBody @Valid Category category,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(categoryService.editCategory(index,category));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> deleteCategory(@PathVariable int index){
        return ResponseEntity.status(200).body(categoryService.deleteCategory(index));
    }
}
