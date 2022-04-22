package com.example.demo.dao;

import com.example.demo.entity.Entertainment_news;
import com.example.demo.entity.International_news;
import com.example.demo.service.Entertain_newsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IInternational_newsDao {
    void push(@Param("id") String id, @Param("source") String source, @Param("title") String title,
              @Param("news_url") String news_url, @Param("datetime") String datetime,
              @Param("img_url_1") String img_url_1, @Param("img_url_2") String img_url_2,
              @Param("img_url_3") String img_url_3);

    void push_content(@Param("id") String id, @Param("content") String content);

    International_news[] pull(@Param("page") int page);

    International_news pull_content(@Param("id") String id);

    International_news pull_title(@Param("id") String id);
}
