package com.ruutja.HotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruutja.HotelService.entity.Hotel;

import com.ruutja.HotelService.service.HService;

@RestController
@RequestMapping("/hotel")
public class HController {
	@Autowired
	private HService service;
	
	
	
	@PostMapping("/save")
	public Hotel savehotel(@RequestBody Hotel hotel)
	{
		return service.savehotel(hotel);
	}
	
	@GetMapping("/getall")
	public List<Hotel> getallhotel()
	{
		return service.getallhotel();
	}
	
	@GetMapping("/getbyhotelid/{id}")
	public Hotel getbyhotelid(@PathVariable int id)
	{
		return service.getbyhotelid(id);
	}
	
	

}
