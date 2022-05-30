package com.example.tuwaiqproject02.service;

import com.example.tuwaiqproject02.model.Category;
import com.example.tuwaiqproject02.model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchants = new ArrayList<>();
    public ArrayList<Merchant> getMerchant() {
        return merchants;
    }

    public boolean addMerchant(Merchant merchant) {
       return merchants.add(merchant);
    }

    public String editMerchant(int index,Merchant merchant) {
        merchants.set(index,merchant);
        return "Product is edit";
    }

    public String deleteMerchant(int index) {
        merchants.remove(index);
        return "Product is deleted";
    }
}
