package com.probal.springmysql.producer.helper;

import com.probal.springmysql.producer.utill.CustomMessage;

public interface IPublisher {
    public String publishMessage(CustomMessage customMessage);
}
