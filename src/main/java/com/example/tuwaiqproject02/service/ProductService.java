package com.example.tuwaiqproject02.service;

import com.example.tuwaiqproject02.model.Comment;
import com.example.tuwaiqproject02.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    ArrayList<Product> products = new ArrayList<>();
    public ArrayList<Product> getProduct() {
        return products;
    }

    public boolean addProduct(Product product) {
       return products.add(product);
    }

    public String editProduct(int index,Product product) {
        products.set(index,product);
        return "Product is edit";
    }
    public Product getProductsID(String poductID){
        for (Product product:products){
            if (product.getId().equals(poductID)){
                return product;
            }
        }
        return null;
    }

    public String deleteProduct(int index) {
        products.remove(index);
        return "Product is deleted";
    }

    public ArrayList<Comment> getAllComment(String productID) {
        for (Product product : products){
            if (product.getId().equals(productID)){
                return product.getComment();
            }

        }
        return null;
    }


}
