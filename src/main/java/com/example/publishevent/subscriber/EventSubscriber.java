package com.example.publishevent.subscriber;


import com.example.publishevent.event.Event;
import com.example.publishevent.listener.EventListener;



public class EventSubscriber implements Runnable {

    EventListener eventListener;
    Event event;

    @Override
    public void run() {
        eventListener.onEvent(event);
    }

    public EventSubscriber(EventListener eventListener, Event event) {
        super();
        this.eventListener = eventListener;
        this.event = event;
    }

}
