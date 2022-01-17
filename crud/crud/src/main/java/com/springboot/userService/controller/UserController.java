package com.springboot.userService.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.realm.api.model.Api;
import com.realm.api.model.Response;
import com.springboot.userService.entity.UserEntity;

import com.springboot.userService.model.User;
import com.springboot.userService.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	
	
	@GetMapping
	public List<UserEntity> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id){
		return ResponseEntity.ok().body(userService.getUserById(id));
	}
	
	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) throws Exception  {
		return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
	}
	
	
	  @PutMapping(value="/updateuser/{id}") 
	  public ResponseEntity<UserEntity> updateUser(@RequestBody User user,@PathVariable Integer id) { 
	   
	 return ResponseEntity.ok().body(userService.updateUser(user,id)); 
	  }
	 	
	
	@DeleteMapping(value="/deleteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id)
	{
		userService.deleteUser(id);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	RestTemplate restTemplate=new RestTemplate();
	@GetMapping("/api/{realId}")
	public Api getApiInfo(@PathVariable Integer realId){
		Api response=restTemplate.getForObject("http://localhost:8081/api/"+realId, Api.class);
		return response;
	}
	
	@GetMapping("/apiuser/{realId}")
	public Response getApiInfoFromUser(@PathVariable Integer realId){
		Response response=restTemplate.getForObject("http://localhost:8081/api/user/"+realId, Response.class);
		return response;
	}

}
