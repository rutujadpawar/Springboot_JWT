package com.ruutja.FoodService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruutja.FoodService.entity.Food;
import com.ruutja.FoodService.repository.Repo;

@Service
public class FService {
	
	@Autowired
	private Repo repo;

	public Food savefood(Food food) {
		// TODO Auto-generated method stub
		return repo.save(food);
	}

	public List<Food> getallfood() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Food getbyid(int id) {
		// TODO Auto-generated method stub
		Optional<Food> optional=repo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
}

	public List<Food> getbyhotelid(int id) {
		// TODO Auto-generated method stub
		return repo.hotelid(id);
	}

}
