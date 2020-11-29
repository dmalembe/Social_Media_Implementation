package com.entreprise.Backenduserservice.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entreprise.Backenduserservice.configuration.AbstractController;
import com.entreprise.Backenduserservice.models.User;
import com.entreprise.Backenduserservice.repository.UserRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user/")
public class UserController extends AbstractController<User>{
	
	@Autowired
	UserRepository userRepository;
	
	
	private Logger logger = LogManager.getLogger(UserController.class);
	
	@GetMapping(path="/allusers")
	public @ResponseBody Iterable<User> getAllusers(HttpServletRequest resquest, HttpServletResponse response){
		
		List<User> Userlist = userRepository.findAll();
		if (Userlist.size()!=0) {
			return Userlist;
		}
		else {
			return null;
		}
	}
	
	@GetMapping(path = "/{id}")
	public @ResponseBody ResponseEntity<User> getUserbyID(HttpServletRequest request,HttpServletResponse response,long id){
		
		Optional<User> retrieveUser = userRepository.findById(id);
		
		if (retrieveUser.isPresent()) {
			return new ResponseEntity<User>(retrieveUser.get(),getHeaders(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(null ,getHeaders(),HttpStatus.OK);
		}
	}
	
	
	@GetMapping(path = "/{username}")
	public @ResponseBody ResponseEntity<User> getUserbyName(HttpServletRequest request, HttpServletResponse response,@PathVariable String username){
		
		Optional<User> RetrieveUser = userRepository.findByUsername(username);
		
		if (RetrieveUser.isPresent()) {
			
			return new ResponseEntity<User>(RetrieveUser.get() ,getHeaders() ,HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<User>(null ,getHeaders(),HttpStatus.OK);
		}
	}
	
	
	
	
}
