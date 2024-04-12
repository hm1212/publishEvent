package com.example.publishevent.event;

import lombok.Getter;
import lombok.Setter;

import java.util.EventObject;

@Getter
@Setter
public class Event<T> extends EventObject {

    public String topic;
    public String uuid;
    public Object data;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public Event(String topic, String uuid, T data) {
        super(data);
        this.data = data;
        this.topic = topic;
        this.uuid = uuid;
    }
}
