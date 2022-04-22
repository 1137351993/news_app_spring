package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.AttentionService;
import com.example.demo.service.Comment_newsService;
import com.example.demo.service.Entertain_newsService;
import com.example.demo.service.HistoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/comment_news")
public class Comment_newsController {
    @Autowired
    private Comment_newsService comment_newsService;

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    private void push(@RequestBody Comment_news comment_news){
        comment_newsService.push(comment_news.getUser_name(), comment_news.getId(), comment_news.getContent());
    }

    @RequestMapping(value = "/init", method = RequestMethod.POST)
    private Comment_news[] init(@RequestParam String id){
        return comment_newsService.init(id);
    }

}
