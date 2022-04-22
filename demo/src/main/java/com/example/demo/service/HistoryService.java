package com.example.demo.service;

import com.example.demo.dao.IEntertainment_newsDao;
import com.example.demo.dao.IHistoryDao;
import com.example.demo.entity.Entertainment_news;
import com.example.demo.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    @Autowired
    private IHistoryDao iHistoryDao;

    public void push(String id, String account, int type) {
        iHistoryDao.push(id, account, type);
    }

    public History[] pull(String account){
        return iHistoryDao.pull(account);
    }

}
