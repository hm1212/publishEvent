package com.example.publishevent.engine.impl;

import com.example.publishevent.engine.EventEngine;
import com.example.publishevent.event.Event;
import com.example.publishevent.listener.EventListener;
import com.example.publishevent.subscriber.EventSubscriber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

@Getter
@Setter
public class DefaultEventEngine implements EventEngine {

    private boolean async;
    public static Map<String, List<EventListener>> subscribers = new ConcurrentHashMap<>(16);

    private Executor executor;

    @Override
    public void add(EventListener listener) {
        subscribers.compute(listener.getTopic(), (k, v) -> {
            if (v == null) {
                v = new ArrayList<>();
            }
            v.add(listener);
            return v;
        });
    }

    @Override
    public void publishEvent(Event event) {
        if (Objects.isNull(subscribers.get(event.getTopic()))) {
            return;
        }
        for (EventListener eventListener : subscribers.get(event.getTopic())) {
            if (async) {
                executor.execute(new EventSubscriber(eventListener,event));
            } else {
                eventListener.onEvent(event);
            }
        }

    }
}
