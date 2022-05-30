package com.example.tuwaiqproject02.service;

import com.example.tuwaiqproject02.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

    ArrayList<User> users = new ArrayList<>();
    public final ProductService productService;
    public final CartService cartService;
    public final MerchantStockService merchantStockService;
    public final PurchaseHistoryService purchaseHistoryService;
    public ArrayList<User> getUser() {
        return users;
    }

    public boolean addUser(User user) {
       return users.add(user);
    }

    public String editUser(int index,User user) {
        users.set(index,user);
        return "User is edit";
    }

    public String deleteUser(int index) {
        users.remove(index);
        return "User is deleted";
    }

    public int addProductToCart(String userID, String productID) {
        boolean isUser = checkUserID(userID);
        if (!isUser){
            return -1;
        }


        Product currentProduct = productService.getProductsID(productID);
        if (currentProduct==null){
            return 0;
        }
        ArrayList<Product> oldCart;


        for(Cart currentCart: cartService.carts){
            if (currentCart.getUserID().equals(userID)){

                oldCart = currentCart.getProducts();
                if(oldCart == null){
                    oldCart = new ArrayList<>();
                    oldCart.add(currentProduct);
                    currentCart.setProducts(oldCart);
                   return 1;
                }
                oldCart.add(currentProduct);
                currentCart.setProducts(oldCart);
                return 1;
            }
        }
                return 1;

    }
    public boolean checkUserID(String userID){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(userID)){
                return true;
            }
        }
        return false;
    }


    public int deleteProductToCart(String userID, String productID) {
        boolean isUser = checkUserID(userID);
        if (!isUser){
            return -1;
        }
        Product currentProduct = productService.getProductsID(productID);
        if (currentProduct==null){
            return 0;
        }
        ArrayList<Product> oldCart;
        for(Cart currentCart: cartService.carts){
            if (currentCart.getUserID().equals(userID)){

                oldCart = currentCart.getProducts();
                if(oldCart == null){

                    return 1;
                }
                oldCart.remove(currentProduct);
                currentCart.setProducts(oldCart);
                return 2;
            }
        }
        return 2;
    }

    public int buyProduct(String userID, String productID, String merchantStockID) {
        MerchantStock currentMerchantID = merchantStockService.getMerchantStockID(merchantStockID);
        if (currentMerchantID == null){
            return -2;
        }
        Product currentProduct = productService.getProductsID(productID);
        if (currentMerchantID.getStock() < 0){
            return -1;
        }
        for (User user: users){
            if(user.getId().equals(userID)){
                if (user.getBalance() > currentProduct.getPrice()){
                    currentMerchantID.setStock(currentMerchantID.getStock()-1);
                    user.setBalance(user.getBalance()-currentProduct.getPrice());
                    purchaseHistoryService.purchaseHistories.add(new PurchaseHistory(userID,userID,currentProduct.getName(), currentProduct.getPrice()));
                    return 0;
                }
                return 1;
            }
        }
        return 2;
    }

    public int buyProductCart(Cart cart) {

        ArrayList<Product> product = cart.getProducts();
        int sumProduct = 0;
        String productID=null;
        String productName=null;
        int productPrice = 0;
        for (int i = 0; i < product.size(); i++) {

            sumProduct += product.get(i).getPrice();
            productID = product.get(i).getId();
            productName = product.get(i).getName();
            productPrice = product.get(i).getPrice();
        }
            for (User user:users){
                if(user.getId().equals(cart.getUserID())){
                        for (MerchantStock merchantStock:merchantStockService.merchantStocks){
                           if (merchantStock.getProductID().equals(productID)){
                               if(merchantStock.getStock() > 0){
                                   if(user.getBalance() >= sumProduct){
                                       user.setBalance(user.getBalance()-sumProduct);
                                       merchantStock.setStock(merchantStock.getStock()-1);
                                       purchaseHistoryService.purchaseHistories.add(new PurchaseHistory(cart.getUserID(),
                                               cart.getUserID(),productName,productPrice));

                                       return 2;
                                   }
                               }
                               return 1;
                           }
                           return 0;
                        }
                }

            }
            return -1;
    }

    public int addComment(String userID, String productID, Comment comment) {
        boolean isUser = checkUserID(userID);
        if(!isUser){
            return -1;
        }
        ArrayList<Comment> oldComment;
        for (Product product : productService.products){
            if (product.getId().equals(productID)){
                oldComment = product.getComment();
                if (oldComment == null){
                    oldComment = new ArrayList<>();
                    oldComment.add(comment);
                    product.setComment(oldComment);
                    return 0;
                }
                oldComment.add(comment);
                product.setComment(oldComment);
                return 0;
            }
        }
        return 1;
    }



}
