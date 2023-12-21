package controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import entities.bookingentities;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/booking")
public class bookingcontroller {

    @PostMapping
    public ResponseEntity<bookingentities> bookRoom(@RequestBody bookingentities bookingInfo) {
        // Generate random room numbers
        List<Integer> randomRoomNumbers = generateRandomRoomNumbers(bookingInfo.getNumOfRooms());
        bookingInfo.setRoomNumbers(randomRoomNumbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        // Calculate room price
        long numOfDays = ChronoUnit.DAYS.between(bookingInfo.getFromDate(), bookingInfo.getToDate()) + 1;
        bookingInfo.setRoomPrice(1000 * bookingInfo.getNumOfRooms() * numOfDays);

        // Save booking information to the database
        // Your database save logic here

        return new ResponseEntity<>(bookingInfo, HttpStatus.CREATED);
    }

//    @PostMapping("/{bookingId}/transaction")
//    public ResponseEntity<String> makeTransaction(
//            @PathVariable Long bookingId,
//            @RequestBody PaymentRequest paymentRequest) {
//        // Call payment service to get transactionId
//        int transactionId = callPaymentService(paymentRequest);
//        
//        // Update booking information with the transactionId
//        // Your database update logic here
//
//        String confirmationMessage = "Booking confirmed. Transaction ID: " + transactionId;
//        return new ResponseEntity<>(confirmationMessage, HttpStatus.OK);
//    }

    private List<Integer> generateRandomRoomNumbers(int numOfRooms) {
        Random random = new Random();
        return random.ints(1, 101)
                .distinct()
                .limit(numOfRooms)
                .boxed()
                .collect(Collectors.toList());
    }

//    private int callPaymentService(PaymentRequest paymentRequest) {
//        // Simulate calling the payment service and getting a transactionId
//        // Your actual implementation would involve making an HTTP request to the payment service
//        // and extracting the transactionId from the response.
//        return 123456; // Replace with actual transactionId
//    }
}
