package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.bookingentities;

//import com.example.booking.Entities.BookingEntities;

public interface bookingrepository extends JpaRepository<bookingentities, Long>{

}
