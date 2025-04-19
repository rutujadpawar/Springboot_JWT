package com.ruutja.FoodService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruutja.FoodService.entity.Food;
import com.ruutja.FoodService.service.FService;

@RestController
@RequestMapping("/food")
public class FController {
	
	@Autowired
	private FService service;
	
	@PostMapping("/save")
	public Food savefood(@RequestBody Food food)
	{
		return service.savefood(food);
	}
	
	@GetMapping("/getall")
	public List<Food> getallfood()
	{
		return service.getallfood();
	}
	
	@GetMapping("/getbyid/{id}")
	public Food getbyid(@PathVariable int id)
	{
		return service.getbyid(id);
	}
	
	@GetMapping("/getbyhotelid/{id}")
	public List<Food> getbyhotelid(@PathVariable int id)
	{
		return service.getbyhotelid(id);
	}

}
