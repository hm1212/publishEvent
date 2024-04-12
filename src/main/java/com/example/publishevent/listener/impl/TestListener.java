package com.example.publishevent.listener.impl;


import com.example.publishevent.event.Event;
import com.example.publishevent.listener.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener implements EventListener {
    @Override
    public boolean isSupport(Event event) {
        return true;
    }

    @Override
    public void onEvent(Event event) {
        System.out.println("只是测试一下");
    }

    @Override
    public String getTopic() {
        return "test";
    }
}
