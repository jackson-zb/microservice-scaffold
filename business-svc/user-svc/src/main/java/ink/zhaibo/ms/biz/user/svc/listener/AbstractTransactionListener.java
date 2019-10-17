package ink.zhaibo.ms.biz.user.svc.listener;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.annotation.Configuration;

@Configuration
public abstract class AbstractTransactionListener implements TransactionListener {
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
