package com.example.publishevent.engine;

import com.example.publishevent.event.Event;
import com.example.publishevent.listener.EventListener;

public interface EventEngine {
    public void  add(EventListener listener);

    public void publishEvent(Event event);
}
