package com.example.homes.service;

import com.example.homes.model.Hotel;

import java.util.List;

public interface HotelService {
    void saveHotel(Hotel hotel);
    List<Hotel> findAllHotels();
    Hotel findHotelById(Long id);
    void deleteHotelById(Long id);
}