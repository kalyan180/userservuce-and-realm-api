package com.realm.api.controller;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.realm.api.dao.ApiDao;
import com.realm.api.model.*;

@RestController
@RequestMapping("/api")
public class ApiController {
		
		@Autowired
		private ApiDao apiDao;

		
		/*
		 * @GetMapping("/user/{id}") public List<Response> getUserById(@PathVariable
		 * Integer id){ RestTemplate restTemplate=new RestTemplate();
		 * 
		 * List<Response> users=Arrays.asList( new
		 * Response(1,"kalyan",52345L,"Bhimavaram","Andhra Pradesh","type",
		 * "kalyana@gmail.com",987654321L,1), new
		 * Response(2,"rajesh",52345L,"Bhimavaram","Andhra Pradesh","type",
		 * "rajesh@gmail.com",987654321L,1)
		 * 
		 * );
		 * 
		 * return users.stream().map(user->{ Response
		 * result=restTemplate.getForObject("http://localhost:8086/users/2" ,
		 * Response.class); return new
		 * Response(result.getId(),result.getName(),result.getEmail());
		 * }).collect(Collectors.toList());
		 * 
		 * 
		 * 
		 * }
		 */
		
		@GetMapping("/{id}")
		public Api getApiById(@PathVariable Integer id){
			return apiDao.getApi(id);
		}
		
		@GetMapping("/user/{id}")
		public Response getUserDetails(@PathVariable Integer id){
			return apiDao.getUserDetails(id);
		}
		
		
		
		@PostMapping("/createapi")
		public Api createApi(@RequestBody Api api)
		{
			return apiDao.createApi(api);
		}
		
		
		  @PutMapping(value="/updateapi") 
		  public Api updateApi(@RequestBody Api api)
		  { 
			  return apiDao.updateApi(api);
		  }
		 	
		
		@DeleteMapping(value="/deleteapi/{id}")
		public String deleteApi(@PathVariable Integer id)
		{
		return apiDao.deleteApiById(id);
		}

	
}
