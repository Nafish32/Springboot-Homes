package com.example.homes.service;

import com.example.homes.model.Hotel;
import com.example.homes.repository.HotelRepository;
import com.example.homes.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void saveHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteHotelById(Long id) {
        hotelRepository.deleteById(id);
    }
}