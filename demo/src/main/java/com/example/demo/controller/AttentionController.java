package com.example.demo.controller;

import com.example.demo.entity.*;
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

    @RequestMapping(value = "/pull_package", method = RequestMethod.POST)
    private Attention_package[] pull_package(@RequestParam String account){
       return attentionService.pull_package(account);
    }

    @RequestMapping(value = "/pull_home_package", method = RequestMethod.POST)
    private Attention_package[] pull_home_package(@RequestParam String account){
        return attentionService.pull_home_package(account);
    }
}
