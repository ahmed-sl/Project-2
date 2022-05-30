package com.example.tuwaiqproject02.controller;

import com.example.tuwaiqproject02.model.Merchant;
import com.example.tuwaiqproject02.model.MerchantStock;
import com.example.tuwaiqproject02.service.MerchantService;
import com.example.tuwaiqproject02.service.MerchantStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchantStock")
@RequiredArgsConstructor
public class MerchantStockController {

    public final MerchantStockService merchantStockService;

    @GetMapping
    public ResponseEntity<ArrayList<MerchantStock>> getMerchantStock(){
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStock());

    }

    @PostMapping
    public ResponseEntity<String> addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
          boolean isAdd=merchantStockService.addMerchantStock(merchantStock);
        if(!isAdd){
            return ResponseEntity.status(400).body("ProductID is wrong");
        }
        return ResponseEntity.status(200).body("Merchant stock add !");

    }

    @PutMapping("/{index}")
    public ResponseEntity<String> editMerchantStock(@PathVariable int index, @RequestBody @Valid MerchantStock merchantStock,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body(merchantStockService.editMerchantStock(index,merchantStock));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> deleteMerchantStock(@PathVariable int index){
        return ResponseEntity.status(200).body(merchantStockService.deleteMerchantStock(index));
    }
}
