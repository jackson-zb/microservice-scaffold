package ink.zhaibo.ms.biz.user.svc.controller;

import com.alibaba.druid.support.json.JSONUtils;
import ink.zhaibo.ms.biz.user.svc.listener.TestTransactionListener;
import ink.zhaibo.ms.biz.user.svc.service.UserService;
import ink.zhaibo.ms.user.api.dto.GetUserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @Author zhaibo
 * @Date 2019/9/20 11:18
 **/
@RestController
@Slf4j
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

   /* @Autowired
    private DefaultMQProducer defaultMQProducer;*/

  /*  @Autowired
    private TestTransactionListener testTransactionListener;

    @Autowired
    private TransactionMQProducer transactionMQProducer;
*/
   /* @GetMapping("testMq")
    public void test(String info) throws Exception {
        Message message = new Message("TopicTest", "Tag1", "12345", "rocketmq测试成功".getBytes());
        defaultMQProducer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("传输成功");
                log.info(JSONUtils.toJSONString(sendResult));
            }

            @Override
            public void onException(Throwable e) {
                log.error("传输失败", e);
            }
        });
    }*/
/*
    @GetMapping("testMqt")
    public void Ttest(String info) throws Exception {
        Message message = new Message("t_TopicTest", "Tag1", "12345", "rocketmq事务消息测试成功".getBytes());
        transactionMQProducer.setTransactionListener(testTransactionListener);
        transactionMQProducer.setSendMsgTimeout(10000);
        transactionMQProducer.sendMessageInTransaction(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("传输成功");
                log.info(JSONUtils.toJSONString(sendResult));
            }

            @Override
            public void onException(Throwable e) {
                log.error("传输失败", e);
            }
        });
    }*/

    @PostMapping("getById")
    public GetUserDto getUser(@NotNull Long userId) {
        return userService.getUser(userId);
    }
}

