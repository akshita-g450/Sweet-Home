package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.paymententities;

//import com.example.booking.Entities.BookingEntities;

public interface paymentrepository extends JpaRepository<paymententities, Integer>{

}
