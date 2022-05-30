package com.example.tuwaiqproject02.service;

import com.example.tuwaiqproject02.model.Comment;
import com.example.tuwaiqproject02.model.PurchaseHistory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PurchaseHistoryService {

    ArrayList<PurchaseHistory> purchaseHistories = new ArrayList<>();
    public ArrayList<PurchaseHistory> getPurchaseHistories() {
        return purchaseHistories;
    }



}
