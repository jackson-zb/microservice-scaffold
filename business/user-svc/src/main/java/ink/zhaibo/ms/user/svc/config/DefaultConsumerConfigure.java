package ink.zhaibo.ms.user.svc.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Slf4j
public abstract class DefaultConsumerConfigure {
    @Autowired
    private ConsumerConfig consumerConfig;

    /**
     * 开启消费者监听服务
     */
    public void listener(String topic, String tag) throws MQClientException {
        log.info("开启" + topic + ":" + tag + "消费者-------------------");
        log.info(consumerConfig.toString());

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerConfig.getGroupName());

        consumer.setNamesrvAddr(consumerConfig.getNamesrvAddr());

        consumer.subscribe(topic, tag);

        // 开启内部类实现监听
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                return DefaultConsumerConfigure.this.dealBody(msgs);
            }
        });
        consumer.start();
        log.info("rocketmq启动成功---------------------------------------");
    }

    // 处理body的业务
    public abstract ConsumeConcurrentlyStatus dealBody(List<MessageExt> msgs);
}
