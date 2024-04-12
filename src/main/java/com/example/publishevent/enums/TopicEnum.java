package com.example.publishevent.enums;

import lombok.Getter;

@Getter
public enum TopicEnum {
    ELASTIC_SEARCH_LOG("/log", "记录日志");

    private String topic;
    private String desc;

    private TopicEnum(String topic, String desc) {
        this.topic = topic;
        this.desc = desc;
    }
}
