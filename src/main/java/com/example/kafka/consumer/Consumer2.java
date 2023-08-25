package com.example.kafka.consumer;

import com.example.wallet.models.Wallet;
import com.example.wallet.service.WalletService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.example.wallet")
public class Consumer2 {
    private final WalletService walletService;

    public Consumer2(WalletService walletService) {
        this.walletService = walletService;
    }

    @KafkaListener(topics = "wallet-events", groupId = "0002")
    public void handleWallet(String action, Wallet wallet) {
        System.out.println("Используется 2 консюмер");
        if (action.equals("deposit")) {
            walletService.depositMoney(wallet.getId(), wallet.getBalance());
        } else if (action.equals("withdraw")) {
            walletService.withdrawMoney(wallet.getId(), wallet.getBalance());
        }
    }
}
