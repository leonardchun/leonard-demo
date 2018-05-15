package com.leonard.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/*
 * 文件名：MessageSender
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2018-05-15 06:44 PM
 */
public class MessageSender {

    private Logger logger = LoggerFactory.getLogger(MessageSender.class);

    //声明一个队列名字
    private final static String QUEUE_NAME = "CHUN";

    public boolean sendMessage(String message) {
        //new一个RabbitMQ的连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置需要连接的RabbitMQ地址，这里指向本机
        factory.setHost("192.168.30.138");
        factory.setUsername("admin");
        factory.setPassword("123456");
        Connection connection = null;
        Channel channel = null;
        try {
            //尝试获取一个连接
            connection = factory.newConnection();
            //尝试创建一个channel
            channel = connection.createChannel();
            //这里的参数在后面详解
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //注意这里调用了getBytes()，发送的其实是byte数组，接收方收到消息后，需要重新组装成String
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            logger.info("Sent '" + message + "'");
            //关闭channel和连接
            channel.close();
            connection.close();
        } catch (IOException | TimeoutException e) {
            //失败后记录日志，返回false，代表发送失败
            logger.error("send message faild!", e);
            return false;
        }
        return true;
    }

}
