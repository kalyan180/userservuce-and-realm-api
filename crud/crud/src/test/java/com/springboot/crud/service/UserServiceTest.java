package com.springboot.crud.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.userService.entity.UserEntity;

import com.springboot.userService.repository.UserRepository;
import com.springboot.userService.service.UserServiceImpl;


@ExtendWith(MockitoExtension.class) 
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	private com.springboot.userService.entity.UserEntity UserEntity=new UserEntity();
	
	
	@Test  
	@DisplayName("junit to test create UserEntity") 
	public void testCreateUser() throws Exception { 
		
		when(userRepository.findAll()).thenReturn(Arrays.asList(new UserEntity(2,"kalyan","kalyan@gmail.com",9887665L,1),
				new UserEntity(3,"srinivas","srinivas@gmail.com",91345678L,2)));
	
		UserEntity userEntity= new UserEntity();
		userEntity.setId(1);
		userEntity.setName("kalyan");
		userEntity.setEmail("kalyan@gmail.com");
		userEntity.setMobile(91345678L);
		userEntity.setRealId(1);
		  List<UserEntity> list=(userRepository.findAll());
		//UserEntity userEntity1= userServiceImpl.createUser(userEntity);
		assertEquals(2,list.size() );
		 
	}
	
	@Test  
	@DisplayName("junit to test get UserEntity") 
	public void testGetUser()  throws Exception {
		UserEntity userEntity= new UserEntity(1,"kalyan","kalyan@gmail.com",91345678L,1);
	
		UserEntity users = userServiceImpl.getUserById(2);
		
		assertNotEquals(userEntity, users);
	}
	
	
	  @Test
	  
	  @DisplayName("junit to test delete UserEntity") public void testDeleteUser()
	  throws Exception {
	  
	  String message= userServiceImpl.deleteUser(1);
	  
	  assertEquals("success",message); }
	  
		@Test
		public void retrieveAllUsers() {
			when(userRepository.findAll()).thenReturn(Arrays.asList(new UserEntity(2,"kalyan","kalyan@gmail.com",9887665L,1),
					new UserEntity(3,"srinivas","srinivas@gmail.com",91345678L,2)));
			java.util.List<UserEntity> users = userServiceImpl.getUsers();
			
			assertEquals("kalyan", users.get(0).getName());
			assertEquals("srinivas", users.get(1).getName());
		}
		
	 
	

}
