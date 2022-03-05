package com.it.demo.mapper;

import java.util.List;

import com.it.demo.model.Comments;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsMapper {
    Integer addComment(Comments comments);
    List<Comments> getAllComments();
}
