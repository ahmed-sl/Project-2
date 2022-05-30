package com.example.tuwaiqproject02.controller;

import com.example.tuwaiqproject02.model.Category;
import com.example.tuwaiqproject02.model.PurchaseHistory;
import com.example.tuwaiqproject02.service.CategoryService;
import com.example.tuwaiqproject02.service.PurchaseHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/purchaseHistory")
@RequiredArgsConstructor
public class PurchaseHistoryController {

    public final PurchaseHistoryService purchaseHistoryService;

    @GetMapping
    public ResponseEntity<ArrayList<PurchaseHistory>> getCategory(){
        return ResponseEntity.status(200).body(purchaseHistoryService.getPurchaseHistories());
    }


}
