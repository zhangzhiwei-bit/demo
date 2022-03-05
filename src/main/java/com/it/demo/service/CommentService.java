package com.it.demo.service;

import java.util.List;

import com.it.demo.model.Comments;

public interface CommentService {
    Integer addComment(Comments comments);
    List<Comments> getAllComments();
}
