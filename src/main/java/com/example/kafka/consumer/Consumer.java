package com.example.kafka.consumer;


import com.example.wallet.models.Wallet;
import com.example.wallet.service.WalletService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private final WalletService walletService;


    public Consumer(WalletService walletService) {
        this.walletService = walletService;
    }

    @KafkaListener(topics = "wallet")
    public void handleWallet(String action, Wallet wallet){
        if (action.equals("deposit")){
            walletService.depositMoney(wallet.getId(),wallet.getBalance());
        }
        else if (action.equals("withdraw")){
            walletService.withdrawMoney(wallet.getId(), wallet.getBalance());
        }
    }


}
