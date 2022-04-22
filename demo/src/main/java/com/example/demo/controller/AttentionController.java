package com.example.demo.controller;

import com.example.demo.entity.Attention;
import com.example.demo.entity.Entertainment_news;
import com.example.demo.entity.History;
import com.example.demo.entity.Users;
import com.example.demo.service.AttentionService;
import com.example.demo.service.Entertain_newsService;
import com.example.demo.service.HistoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/attention")
public class AttentionController {
    @Autowired
    private AttentionService attentionService;

    @RequestMapping(value = "/push", method = RequestMethod.POST)
    private void push(@RequestBody Attention attention){
        attentionService.push(attention.getId(), attention.getAccount(), attention.getPackage_id());
    }

    @RequestMapping(value = "/pull", method = RequestMethod.POST)
    private void pull(@RequestParam String account){

    }
}
