package com.example.homes.service;

import com.example.homes.model.Booking;
import com.example.homes.model.BookingDetails;

import java.util.List;

public interface BookingService {
    void saveBooking(Booking booking);
    List<Booking> findAllBookings();
    Booking findBookingById(Long id);
    void deleteBookingById(Long id);

    // New methods for BookingDetails
    void saveBookingDetails(BookingDetails bookingDetails);
    List<BookingDetails> findAllBookingDetails();
    BookingDetails findBookingDetailsById(Long id);
    void deleteBookingDetailsById(Long id);
}
