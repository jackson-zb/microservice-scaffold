package ink.zhaibo.ms.biz.user.svc.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class TestTransactionListener extends AbstractTransactionListener {
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        log.info(new String(msg.getBody()));
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}