package com.example.demo.service;

import com.example.demo.dao.IAttentionDao;
import com.example.demo.dao.IComment_newsDao;
import com.example.demo.dao.IEntertainment_newsDao;
import com.example.demo.dao.IHistoryDao;
import com.example.demo.entity.Comment_news;
import com.example.demo.entity.Entertainment_news;
import com.example.demo.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Comment_newsService {
    @Autowired
    private IComment_newsDao iComment_newsDao;

    public void push(String user_name, String id, String content) {
        iComment_newsDao.push(user_name, id, content);
    }

    public Comment_news[] init(String id) {
        return iComment_newsDao.init(id);
    }

}
