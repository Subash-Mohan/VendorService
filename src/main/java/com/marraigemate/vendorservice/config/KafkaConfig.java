package com.marraigemate.vendorservice.config;

import com.marraigemate.vendorservice.constant.AppConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin.NewTopics;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopics topics() {
        return new NewTopics(
                TopicBuilder.name(AppConstant.VENDOR_REGISTERED).build(),
                TopicBuilder.name(AppConstant.VENDOR_UPDATED).build(),
                TopicBuilder.name(AppConstant.VENDOR_DELETED).build()
        );
    }
}
