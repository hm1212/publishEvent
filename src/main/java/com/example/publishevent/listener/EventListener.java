package com.example.publishevent.listener;


import com.example.publishevent.event.Event;

public interface EventListener extends java.util.EventListener {

    public boolean isSupport(Event event);

    public void onEvent(Event event);

    public String getTopic();

}
