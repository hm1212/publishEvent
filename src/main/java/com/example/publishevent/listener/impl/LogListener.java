package com.example.publishevent.listener.impl;


import com.example.publishevent.event.Event;
import com.example.publishevent.listener.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class LogListener implements EventListener {
    @Override
    public boolean isSupport(Event event) {
        return true;
    }

    @Override
    public void onEvent(Event event) {
        System.out.println("开始记录日志信息");
    }

    @Override
    public String getTopic() {
        return "log";
    }

}
