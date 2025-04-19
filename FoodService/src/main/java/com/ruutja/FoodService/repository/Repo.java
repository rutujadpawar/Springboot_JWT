package com.ruutja.FoodService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruutja.FoodService.entity.Food;

@Repository
public interface Repo extends JpaRepository<Food, Integer>{

	List<Food> hotelid(int id);

}
