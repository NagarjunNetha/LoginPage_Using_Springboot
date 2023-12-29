package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.repo.UserRepo;
import com.app.model.User;

@RestController
@RequestMapping("user/")

@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserRepo repo; 
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User userData){
		com.app.model.User user=repo.findByUserId(((com.app.model.User) userData).getUserId());
		if(((com.app.model.User) user).getPassword().equals(((com.app.model.User) userData).getPassword()))
			 return ResponseEntity.ok(user);
		  return (ResponseEntity<?>) ResponseEntity.internalServerError() ;
	}

}
