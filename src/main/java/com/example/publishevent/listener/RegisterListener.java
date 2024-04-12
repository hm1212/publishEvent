package com.example.publishevent.listener;


import com.example.publishevent.engine.EventEngine;
import com.example.publishevent.engine.impl.DefaultEventEngine;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class RegisterListener {

    @Bean("engineExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("engineExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        return executor;
    }

    @Bean
    @ConditionalOnMissingBean
    public EventEngine register(ObjectProvider<EventListener> listeners, @Qualifier("engineExecutor") Executor ThreadPoolTaskExecutor) {
        DefaultEventEngine eventEngine = new DefaultEventEngine();
        listeners.forEach(eventEngine::add);
        eventEngine.setExecutor(ThreadPoolTaskExecutor);
        eventEngine.setAsync(true);
        return eventEngine;
    }

}
