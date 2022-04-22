package com.example.demo.controller;

import com.example.demo.entity.Entertainment_news;
import com.example.demo.entity.International_news;
import com.example.demo.service.International_newsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/international_news")
public class International_newsController {
    @Autowired
    private International_newsService international_newsService;

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    private void push(@RequestBody International_news international_news){
        international_newsService.push(international_news.getId(), international_news.getSource(),
                international_news.getTitle(), international_news.getNews_url(), international_news.getDatetime(),
                international_news.getImg_url_1(), international_news.getImg_url_2(),
                international_news.getImg_url_3());
    }

    @RequestMapping(value = "/push_content", method = RequestMethod.POST)
    private void push_content(@RequestBody International_news international_news){
        international_newsService.push_content(international_news.getId(), international_news.getContent());
    }

    @RequestMapping(value = "/pull", method = RequestMethod.POST)
    private International_news[] pull(@RequestParam int page){
        return international_newsService.pull(page);
    }

    @RequestMapping(value="/pull_content", method = RequestMethod.POST)
    private International_news pull_content(@RequestParam String id){
        return international_newsService.pull_content(id);
    }

    @RequestMapping(value="/pull_title", method = RequestMethod.POST)
    private International_news pull_title(@RequestParam String id){
        return international_newsService.pull_title(id);
    }
}
