package com.example.demo.dao;

import com.example.demo.entity.Comment_news;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IComment_newsDao {
    void push(@Param("user_name") String user_name, @Param("id") String id, @Param("content") String content);

    Comment_news[] init(@Param("id") String id);
}
