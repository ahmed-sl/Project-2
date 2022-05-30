package com.example.tuwaiqproject02.service;

import com.example.tuwaiqproject02.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    ArrayList<Category> categories = new ArrayList<>();
    public ArrayList<Category> getCategory() {
        return categories;
    }

    public boolean addCategory(Category category) {
       return categories.add(category);
    }

    public String editCategory(int index,Category category) {
        categories.set(index,category);
        return "Product is edit";
    }

    public String deleteCategory(int index) {
        categories.remove(index);
        return "Product is deleted";
    }
}
