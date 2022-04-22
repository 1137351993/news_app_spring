package com.example.demo.dao;

import com.example.demo.entity.Entertainment_news;
import com.example.demo.entity.History;
import com.example.demo.service.Entertain_newsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistoryDao {
    void push(@Param("id") String id, @Param("account") String source, @Param("type") int type);

    History[] pull(@Param("account") String account);
}
