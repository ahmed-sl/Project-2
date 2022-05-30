package com.example.tuwaiqproject02.service;

import com.example.tuwaiqproject02.model.Merchant;
import com.example.tuwaiqproject02.model.MerchantStock;
import com.example.tuwaiqproject02.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();
    public final ProductService productService;
    public ArrayList<MerchantStock> getMerchantStock() {
        return merchantStocks;
    }
    public boolean addMerchantStock(MerchantStock merchantStock) {

        Product productID = productService.getProductsID(merchantStock.getProductID());
        if (productID==null){
           return false;
        }

       return merchantStocks.add(merchantStock);
    }

    public String editMerchantStock(int index,MerchantStock merchantStock) {
        merchantStocks.set(index,merchantStock);
        return "Product is edit";
    }

    public String deleteMerchantStock(int index) {
        merchantStocks.remove(index);
        return "Product is deleted";
    }
    public MerchantStock getMerchantStockID(String merchantStockID){
        for (MerchantStock merchantStock:merchantStocks){
            if (merchantStock.getId().equals(merchantStockID)){
                return merchantStock;
            }
        }
        return null;
    }
}
