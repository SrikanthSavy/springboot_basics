package com.shoda.rest.webservices.restful_web_servies.user;

import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*; // will import all the methods of this class as static

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	// GET /users -> to do we need DAO service (autowire) (constructor/setter /field
	// injection)
	@Autowired // optional
	private UserDaoService daoService;

	// Construction Injection
	public UserResource(UserDaoService daoService) {
		System.out.println("Construction Injection of DAo service");
		this.daoService = daoService;
	}

	// "/users" - get all Users
	@GetMapping(path = "/users")
	public List<User> getUsers() {
		return daoService.findAll();
	}

	
	//To add Hateoas - i.e link to AllUser method() 
	//3 steps  .   	1) Step : Wrap User  == > EntityModel<user>
	//				2) Step: Import All use static import  WebMvcLinkBuilder and use linkTo() & MethodOf()
	//				3) Use WebMvcLinkBuilder to link it to a Method
	
	// "/users/{id}" get Specific User
	@GetMapping(path = "/users/{userId}")
	public EntityModel<User> getUsersById(@PathVariable int userId) {
		User user = daoService.findOne(userId);
		//Exception handlin: When User is null we "throw" our own exception 
		if(user==null)
			throw new UserNotFoundException("id  :"+userId);
		
		//Hateoas Concept
		EntityModel<User> entityModel = EntityModel.of(user); //static method of(object)
		
		//Linking method to response  // Adding "getUsers() and linkin it
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers()); 
		
		//add this link to EnityModel
		entityModel.add(link.withRel("all-users"));
 		
		return entityModel;
	}

	// Create a User POST /users
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = daoService.save(user);

		// User CurrentRequest = localhost8080/users
		//add /{userId} to it
		//Replace it with - saved UserId
		//convert to URI
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	//Delete a User for given Id
	@DeleteMapping(path = "/users/{userId}")
	public User deleteUsersById(@PathVariable int userId) {
		User user = daoService.delete(userId);
		//Exception handlin: When User is null we "throw" our own exception 
		if(user==null)
			throw new UserNotFoundException("id  :"+userId);
		
		
		return user;
	}

}
