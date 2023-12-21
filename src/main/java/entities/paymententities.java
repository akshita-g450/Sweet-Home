package entities;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class paymententities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionId")
    private int transactionId;

    @Column(nullable = false, name = "paymentMode")
    private String paymentMode;

    @Column(nullable = false, name = "bookingId")
    private int bookingId;

    @Column(name = "upiId")
    private String upiId;

    @Column(name = "cardNumber")
    private String cardNumber;

    // Constructors, getters, and setters

    public paymententities() {
        // Default constructor
    }

    public paymententities(String paymentMode, int bookingId, String upiId, String cardNumber) {
        this.paymentMode = paymentMode;
        this.bookingId = bookingId;
        this.upiId = upiId;
        this.cardNumber = cardNumber;
    }

    // Other getters and setters

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
