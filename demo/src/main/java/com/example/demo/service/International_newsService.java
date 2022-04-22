package com.example.demo.service;

import com.example.demo.dao.IInternational_newsDao;
import com.example.demo.entity.Entertainment_news;
import com.example.demo.entity.International_news;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class International_newsService {
    @Autowired
    private IInternational_newsDao iInternational_newsDao;

    public void push(String id, String source, String title, String news_url, String datetime,
                     String img_url_1, String img_url_2, String img_url_3) {
        iInternational_newsDao.push(id, source, title, news_url, datetime, img_url_1, img_url_2, img_url_3);
    }

    public void push_content(String id, String content){
        iInternational_newsDao.push_content(id, content);
    }

    public International_news[] pull(int page){
        return iInternational_newsDao.pull(page);
    }

    public International_news pull_content(String id){
        return iInternational_newsDao.pull_content(id);
    }

    public International_news pull_title(String id){ return iInternational_newsDao.pull_title(id);}
}
