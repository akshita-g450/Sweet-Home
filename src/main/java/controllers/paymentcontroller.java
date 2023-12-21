package controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import entities.paymententities;
import services.paymentservice;

@RestController
@RequestMapping("/transaction")
public class paymentcontroller {

    private final paymentservice paymentService;

    public paymentcontroller(paymentservice paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Integer> performTransaction(
            @RequestParam String paymentMode,
            @RequestParam int bookingId,
            @RequestParam(required = false) String upiId,
            @RequestParam(required = false) String cardNumber) {

        int transactionId = paymentService.performTransaction(paymentMode, bookingId, upiId, cardNumber);

        // Print confirmation message on the console
        System.out.println("Booking confirmed for user with bookingId: " + bookingId);

        return new ResponseEntity<>(transactionId, HttpStatus.CREATED);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<paymententities> getTransactionDetails(@PathVariable int transactionId) {
        return paymentService.getTransactionDetailsById(transactionId)
                .map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
