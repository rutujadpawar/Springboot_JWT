package com.ruutja.HotelService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruutja.HotelService.entity.Food;
import com.ruutja.HotelService.entity.Hotel;
import com.ruutja.HotelService.feigncomm.Feign;
import com.ruutja.HotelService.repository.Repo;

@Service
public class HService {
	
	@Autowired
	private Repo repo;
	
	@Autowired
	private Feign feign;

	public Hotel savehotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return repo.save(hotel);
	}

	public List<Hotel> getallhotel() {
		// TODO Auto-generated method stub
		List<Hotel> hotels=repo.findAll();
		return hotels.stream().map(hotel->{
			List<Food> foodList=feign.getbyhotelid(hotel.getId());
			hotel.setFoods(foodList);
			return hotel;
		}).toList();
				
	}

	public Hotel getbyhotelid(int id) {
		// TODO Auto-generated method stub
		Optional<Hotel> optional=repo.findById(id);
		if(optional.isPresent())
		{
			Hotel hotels=optional.get();
			List<Food> foodList=feign.getbyhotelid(id);
			hotels.setFoods(foodList);
			return hotels;
		}
		return null;
	}

	

}
