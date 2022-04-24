package com.example.demo.dao;

import com.example.demo.entity.Entertainment_news;
import com.example.demo.entity.Tag;
import com.example.demo.service.Entertain_newsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntertainment_newsDao {
    void push(@Param("id") String id, @Param("source") String source, @Param("title") String title,
              @Param("news_url") String news_url, @Param("datetime") String datetime,
              @Param("img_url_1") String img_url_1, @Param("img_url_2") String img_url_2,
              @Param("img_url_3") String img_url_3);

    void push_content(@Param("id") String id, @Param("content") String content);

    Entertainment_news[] pull(@Param("page") int page);

    Entertainment_news pull_content(@Param("id") String id);

    Entertainment_news[] pull_history(@Param("account") String account);

    Entertainment_news[] pull_attention(@Param("package_id") int package_id);

    Tag[] pull_attention_tag(@Param("name") String name, @Param("account") String account);

    Entertainment_news[] pull_select(@Param("key") String key);

    Tag[] pull_all();

    void push_tag(@Param("id") String id, @Param("tag1") String tag1, @Param("tag1_weight") double tag1_weight,
                  @Param("tag2") String tag2, @Param("tag2_weight") double tag2_weight,
                  @Param("tag3") String tag3, @Param("tag3_weight") double tag3_weight,
                  @Param("tag4") String tag4, @Param("tag4_weight") double tag4_weight,
                  @Param("tag5") String tag5, @Param("tag5_weight") double tag5_weight,
                  @Param("tag6") String tag6, @Param("tag6_weight") double tag6_weight,
                  @Param("tag7") String tag7, @Param("tag7_weight") double tag7_weight,
                  @Param("tag8") String tag8, @Param("tag8_weight") double tag8_weight,
                  @Param("tag9") String tag9, @Param("tag9_weight") double tag9_weight,
                  @Param("tag10") String tag10, @Param("tag10_weight") double tag10_weight);

    Tag pull_tag(@Param("id") String id);


}
