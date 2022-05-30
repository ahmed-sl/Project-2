package com.example.tuwaiqproject02.controller;

import com.example.tuwaiqproject02.model.Category;
import com.example.tuwaiqproject02.model.Merchant;
import com.example.tuwaiqproject02.service.CategoryService;
import com.example.tuwaiqproject02.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    public final MerchantService merchantService;

    @GetMapping
    public ResponseEntity<ArrayList<Merchant>> getMerchant(){
        return ResponseEntity.status(200).body(merchantService.getMerchant());

    }

    @PostMapping
    public ResponseEntity<String> addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
          boolean isAdd=merchantService.addMerchant(merchant);
        if(!isAdd){
            return ResponseEntity.status(500).body("some error in add !!");
        }
        return ResponseEntity.status(200).body("Product add !");

    }

    @PutMapping("/{index}")
    public ResponseEntity<String> editMerchant(@PathVariable int index, @RequestBody @Valid Merchant merchant,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(merchantService.editMerchant(index,merchant));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> deleteMerchant(@PathVariable int index){
        return ResponseEntity.status(200).body(merchantService.deleteMerchant(index));
    }
}
