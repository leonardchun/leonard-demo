package com.leonard.demo.rabbitmq;

/*
 * 文件名：App
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2018-05-15 06:47 PM
 */
public class App {

    public static void main(String[] args) {
        MessageSender sender = new MessageSender();
        sender.sendMessage("hello RabbitMQ!");
    }
}
