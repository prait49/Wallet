package com.example.kafka.producer;

import com.example.wallet.models.Wallet;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;


@Component
public class Producer {

    private final KafkaTemplate<String, Wallet> kafkaTemplate;
    private static final String TOPIC = "wallet";

    public Producer(KafkaTemplate<String, Wallet> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendWalletEvent(String action, Wallet event) {
        kafkaTemplate.send(TOPIC, action, event);
    }
}
