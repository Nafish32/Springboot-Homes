package com.example.homes.service;

import com.example.homes.model.Booking;
import com.example.homes.model.BookingDetails;
import com.example.homes.repository.BookingRepository;
import com.example.homes.repository.BookingDetailsRepository;
import com.example.homes.exception.BookingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    @Override
    public void saveBooking(Booking booking) {
        try {
            bookingRepository.save(booking);
            logger.info("Booking saved successfully: {}", booking.getId());
        } catch (Exception e) {
            logger.error("Error saving booking: {}", e.getMessage());
            throw new RuntimeException("Failed to save booking");
        }
    }

    @Override
    public List<Booking> findAllBookings() {
        try {
            return bookingRepository.findAll();
        } catch (Exception e) {
            logger.error("Error retrieving bookings: {}", e.getMessage());
            throw new RuntimeException("Failed to retrieve bookings");
        }
    }

    @Override
    public Booking findBookingById(Long id) throws BookingNotFoundException {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            return bookingOptional.get();
        } else {
            logger.warn("Booking not found with ID: {}", id);
            throw new BookingNotFoundException("Booking not found with ID: " + id);
        }
    }

    @Override
    public void deleteBookingById(Long id) {
        try {
            if (bookingRepository.existsById(id)) {
                bookingRepository.deleteById(id);
                logger.info("Booking deleted successfully: {}", id);
            } else {
                logger.warn("Attempt to delete non-existing booking with ID: {}", id);
                throw new BookingNotFoundException("Booking not found with ID: " + id);
            }
        } catch (Exception e) {
            logger.error("Error deleting booking with ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Failed to delete booking");
        }
    }

    @Override
    public void saveBookingDetails(BookingDetails bookingDetails) {
        try {
            bookingDetailsRepository.save(bookingDetails);
            logger.info("Booking details saved successfully: {}", bookingDetails.getId());
        } catch (Exception e) {
            logger.error("Error saving booking details: {}", e.getMessage());
            throw new RuntimeException("Failed to save booking details");
        }
    }

    @Override
    public List<BookingDetails> findAllBookingDetails() {
        try {
            return bookingDetailsRepository.findAll();
        } catch (Exception e) {
            logger.error("Error retrieving booking details: {}", e.getMessage());
            throw new RuntimeException("Failed to retrieve booking details");
        }
    }

    @Override
    public BookingDetails findBookingDetailsById(Long id) {
        Optional<BookingDetails> bookingDetailsOptional = bookingDetailsRepository.findById(id);
        if (bookingDetailsOptional.isPresent()) {
            return bookingDetailsOptional.get();
        } else {
            logger.warn("Booking details not found with ID: {}", id);
            throw new RuntimeException("Booking details not found with ID: " + id);
        }
    }

    @Override
    public void deleteBookingDetailsById(Long id) {
        try {
            if (bookingDetailsRepository.existsById(id)) {
                bookingDetailsRepository.deleteById(id);
                logger.info("Booking details deleted successfully: {}", id);
            } else {
                logger.warn("Attempt to delete non-existing booking details with ID: {}", id);
                throw new RuntimeException("Booking details not found with ID: " + id);
            }
        } catch (Exception e) {
            logger.error("Error deleting booking details with ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Failed to delete booking details");
        }
    }
}