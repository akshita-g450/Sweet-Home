package services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.bookingentities;
import repository.bookingrepository;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class bookingserviceImpl implements bookingservice {

    @Autowired
    private bookingrepository bookingRepository;

    @Override
    public bookingentities bookRoom(bookingentities bookingInfo) {
        // Generate random room numbers
        List<Integer> randomRoomNumbers = generateRandomRoomNumbers(bookingInfo.getNumOfRooms());
        bookingInfo.setRoomNumbers(randomRoomNumbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        // Calculate room price
        long numOfDays = ChronoUnit.DAYS.between(bookingInfo.getFromDate(), bookingInfo.getToDate()) + 1;
        bookingInfo.setRoomPrice(1000 * bookingInfo.getNumOfRooms() * numOfDays);

        // Save booking information to the database
        return bookingRepository.save(bookingInfo);
    }

    @Override
    public List<bookingentities> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public bookingentities getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @Override
    public bookingentities updateBooking(Long bookingId, bookingentities bookingInfo) {
        // Perform update logic based on your requirements
        // ...

        return bookingRepository.save(bookingInfo);
    }

    @Override
    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public List<bookingentities> getAllBookingsByUserId(Long userId) {
        // Implement logic to retrieve bookings by user ID
        // ...

        return null;
    }

    private List<Integer> generateRandomRoomNumbers(int numOfRooms) {
        Random random = new Random();
        return random.ints(1, 101)
                .distinct()
                .limit(numOfRooms)
                .boxed()
                .collect(Collectors.toList());
    }
}
