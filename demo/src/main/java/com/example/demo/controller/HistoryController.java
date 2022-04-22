package com.example.demo.controller;

import com.example.demo.entity.Entertainment_news;
import com.example.demo.entity.History;
import com.example.demo.entity.Users;
import com.example.demo.service.Entertain_newsService;
import com.example.demo.service.HistoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    private void push(@RequestBody History history){
        historyService.push(history.getId(), history.getAccount(), history.getType());
    }

    @RequestMapping(value = "/pull", method = RequestMethod.POST)
    private History[] pull(@RequestParam String account){
        return historyService.pull(account);
    }

}
