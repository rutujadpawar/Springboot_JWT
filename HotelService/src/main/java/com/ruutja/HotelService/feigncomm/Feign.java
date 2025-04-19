package com.ruutja.HotelService.feigncomm;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import com.ruutja.HotelService.entity.Food;



@FeignClient(name="FoodService")
public interface Feign {
	
	
	
	
	@GetMapping("/food/getall")
	public List<Food> getallfood();
	
	@GetMapping("/food/getbyid/{id}")
	public Food getbyid(@PathVariable int id);
	
	@GetMapping("/food/getbyhotelid/{id}")
	public List<Food> getbyhotelid(@PathVariable int id);

}
