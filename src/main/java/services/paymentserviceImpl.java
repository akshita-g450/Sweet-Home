package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.bookingentities;
import entities.paymententities;
import repository.paymentrepository;

import java.util.Optional;

@Service
public class paymentserviceImpl implements paymentservice {

    private final paymentrepository paymentRepository;

    @Autowired
    public paymentserviceImpl(paymentrepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public int performTransaction(String paymentMode, int bookingId, String upiId, String cardNumber) {
       paymententities transactionEntity = new paymententities(paymentMode, bookingId, upiId, cardNumber);
       paymententities savedEntity = paymentRepository.save(transactionEntity);
        return savedEntity.getTransactionId();
    }

    @Override
    public Optional<paymententities> getTransactionDetailsById(int transactionId) {
        return paymentRepository.findById(transactionId);
    }
}
