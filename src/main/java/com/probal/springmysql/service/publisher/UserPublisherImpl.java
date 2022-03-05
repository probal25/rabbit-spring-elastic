package com.probal.springmysql.service.publisher;

import com.probal.springmysql.helper.IPublisher;
import com.probal.springmysql.helper.MQConfigProperties;
import com.probal.springmysql.utill.CustomMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class UserPublisherImpl implements IPublisher {

    private final RabbitTemplate template;

    @Autowired
    public UserPublisherImpl(RabbitTemplate template) {
        this.template = template;
    }

    @Override
    public String publishMessage(CustomMessage message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfigProperties.USER_MESSAGE_EXCHANGE_TOPIC,
                MQConfigProperties.USER_MESSAGE_ROUTING_KEY, message);
        log.info("Message is published");
        return "Message is published";

    }
}
