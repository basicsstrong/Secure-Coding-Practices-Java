package com.basicsstrong.securecoding;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerExample {
    private static final Logger logger = LogManager.getLogger(LoggerExample.class);

    public static void main(String[] args) {
        transferFunds("John", "Ron", 100.0);
    }

    public static void transferFunds(String sender, String recipient, double amount) {
        // Perform the funds transfer
        // ...

    	logger.info(" Action: {}, Sender: {}, Amount: {}, Receiver: {}", "Transfer",sender, amount, recipient);
    }
}
