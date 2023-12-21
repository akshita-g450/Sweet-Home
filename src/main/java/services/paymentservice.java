package services;

import java.util.Optional;

import entities.paymententities;

public interface paymentservice {

    int performTransaction(String paymentMode, int bookingId, String upiId, String cardNumber);

    Optional<paymententities> getTransactionDetailsById(int transactionId);
}
