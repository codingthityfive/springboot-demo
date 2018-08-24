package com.sd.controller;

import com.sd.rocketmq.Producer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @program: springboot-demo
 * @description: RocketMQ测试
 * @author: zZ
 * @create: 2018-08-23 16:36
 **/
@RestController
public class RocketMQTestController {

    @Autowired
    private Producer producer;

    @GetMapping(value = "/push/{msg}")
    public String pushMsg(@PathVariable("msg") String msg){
        try {
            return producer.send("PushTopic","push",msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
}
