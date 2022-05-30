package com.example.tuwaiqproject02.controller;

import com.example.tuwaiqproject02.model.Cart;
import com.example.tuwaiqproject02.model.Comment;
import com.example.tuwaiqproject02.service.CartService;
import com.example.tuwaiqproject02.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    public final CommentService commentService;

    @GetMapping
    public ResponseEntity<ArrayList<Comment>> getCart(){
        return ResponseEntity.status(200).body(commentService.getComments());
    }
    @GetMapping("/getRate")
    public ResponseEntity<Object> getRate(){
        return ResponseEntity.status(200).body(commentService.getRate());
    }
}
