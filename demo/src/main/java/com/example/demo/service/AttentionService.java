package com.example.demo.service;

import com.example.demo.dao.IAttentionDao;
import com.example.demo.dao.IEntertainment_newsDao;
import com.example.demo.dao.IHistoryDao;
import com.example.demo.entity.Entertainment_news;
import com.example.demo.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttentionService {
    @Autowired
    private IAttentionDao iAttentionDao;

    public void push(String id, String account, int package_id) {
        iAttentionDao.push(id, account, package_id);
    }

}
