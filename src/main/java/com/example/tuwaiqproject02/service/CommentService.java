package com.example.tuwaiqproject02.service;

import com.example.tuwaiqproject02.model.Cart;
import com.example.tuwaiqproject02.model.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentService {

    ArrayList<Comment> comments = new ArrayList<>();
    public ArrayList<Comment> getComments() {
        return comments;
    }


    public Object getRate() {
        ArrayList<Comment> rate5 = new ArrayList<>();
        for (Comment comment:comments){
            if (comment.getRate() == 5){
                rate5.add(comment);
                return rate5;
            }
        }
        return null;
    }
}
