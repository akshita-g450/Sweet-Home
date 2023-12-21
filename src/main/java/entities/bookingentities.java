package entities;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class bookingentities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=true)
    private LocalDate fromDate;
    
    @Column(nullable=true)
    private LocalDate toDate;
    
    @Column(nullable=true)
    private String aadharNumber;
    private int numOfRooms;
    private String roomNumbers;
    
    @Column(nullable=false)
    private double roomPrice;
    
    @Column(nullable=false)
    private LocalDate bookedOn;
    private int transactionId;

    // Constructors, getters, and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter for fromDate
    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    // Getter and setter for toDate
    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    // Getter and setter for aadharNumber
    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    // Getter and setter for numOfRooms
    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    // Getter and setter for roomNumbers
    public String getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(String roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    // Getter and setter for roomPrice
    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    // Getter and setter for paymentMode
    public LocalDate getbookesOn() {
        return bookedOn;
    }

    public void setbookedOn(LocalDate bookedOn) {
        this.bookedOn = bookedOn;
    }

    // Getter and setter for cardNumber
    // Getter and setter for transactionId
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
