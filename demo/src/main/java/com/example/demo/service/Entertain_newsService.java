package com.example.demo.service;

import com.example.demo.dao.IEntertainment_newsDao;
import com.example.demo.entity.Entertainment_news;
import com.example.demo.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.demo.util.getMax;
import static java.lang.Math.sqrt;

@Service
public class Entertain_newsService {
    @Autowired
    private IEntertainment_newsDao ientertainment_newsDao;

    public void push(String id, String source, String title, String news_url, String datetime,
                     String img_url_1, String img_url_2, String img_url_3) {
        ientertainment_newsDao.push(id, source, title, news_url, datetime, img_url_1, img_url_2, img_url_3);
    }

    public void push_content(String id, String content){
        ientertainment_newsDao.push_content(id, content);
    }

    public Entertainment_news[] pull(int page){
        return ientertainment_newsDao.pull(page);
    }

    public Entertainment_news pull_content(String id){
        return ientertainment_newsDao.pull_content(id);
    }

    public Entertainment_news[] pull_history(String account){ return ientertainment_newsDao.pull_history(account);}

    public Entertainment_news[] pull_attention(int package_id){ return ientertainment_newsDao.pull_attention(package_id);}

    public Entertainment_news[] pull_select(String key){ return ientertainment_newsDao.pull_select(key);}

    public Tag[] pull_all(){ return ientertainment_newsDao.pull_all(); }

    public void push_tag(String id, String tag1, double tag1_weight, String tag2, double tag2_weight, String tag3, double tag3_weight,
                         String tag4, double tag4_weight, String tag5, double tag5_weight, String tag6, double tag6_weight,
                         String tag7, double tag7_weight, String tag8, double tag8_weight, String tag9, double tag9_weight,
                         String tag10, double tag10_weight){
        ientertainment_newsDao.push_tag(id, tag1, tag1_weight, tag2, tag2_weight, tag3, tag3_weight, tag4, tag4_weight,
                tag5, tag5_weight, tag6, tag6_weight, tag7, tag7_weight, tag8, tag8_weight, tag9, tag9_weight,
                tag10, tag10_weight);
    }

    public Tag pull_tag(String id){
        return ientertainment_newsDao.pull_tag(id);
    }

}
