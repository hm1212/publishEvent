package com.example.publishevent.controller;


import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONUtil;
import com.example.publishevent.engine.EventEngine;
import com.example.publishevent.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    EventEngine engine;

    @GetMapping
    public void recordLog() {
        engine.publishEvent(new Event("log", UUID.fastUUID().toString(), "日志"));
        engine.publishEvent(new Event("test", UUID.fastUUID().toString(), "测试"));
    }

}
