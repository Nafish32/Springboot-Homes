package com.example.homes.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guestName;
    private String guestNID;
    private String guestContactNumber;

    private Double totalPrice;  // Total price for the booking
    private Integer days; // Number of days the guest stays
    private String paymentMethod; // Cash or Credit Card

    private LocalDateTime bookingTime; // Timestamp for the booking time

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @ElementCollection
    @CollectionTable(name = "booking_room_counts", joinColumns = @JoinColumn(name = "booking_id"))
    @MapKeyColumn(name = "room_type")
    @Column(name = "room_count")
    private Map<String, Integer> roomCounts; // Store room counts as a map

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestNID() {
        return guestNID;
    }

    public void setGuestNID(String guestNID) {
        this.guestNID = guestNID;
    }

    public String getGuestContactNumber() {
        return guestContactNumber;
    }

    public void setGuestContactNumber(String guestContactNumber) {
        this.guestContactNumber = guestContactNumber;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Map<String, Integer> getRoomCounts() {
        return roomCounts;
    }

    public void setRoomCounts(Map<String, Integer> roomCounts) {
        this.roomCounts = roomCounts;
    }
}
