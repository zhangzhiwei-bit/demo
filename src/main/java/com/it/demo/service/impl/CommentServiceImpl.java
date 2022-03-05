package com.it.demo.service.impl;


import java.util.List;

import com.it.demo.mapper.CommentsMapper;
import com.it.demo.model.Comments;
import com.it.demo.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{


    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public Integer addComment(Comments comments) {
        return commentsMapper.addComment(comments);
    }

    @Override
    public List<Comments> getAllComments() {
        return commentsMapper.getAllComments();
    }
}
