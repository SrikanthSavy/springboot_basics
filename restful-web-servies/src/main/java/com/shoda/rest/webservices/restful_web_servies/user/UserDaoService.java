package com.shoda.rest.webservices.restful_web_servies.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component  // We want Spring to manage this class
public class UserDaoService {
	
	// For now lets have a static List
	private static List<User> userList = new ArrayList<User>();
	static int idCounter = 0;
	
	static {
		userList.add(new User(++idCounter, "Shoda", LocalDate.now().minusYears(30)));
		userList.add(new User(++idCounter, "Srikanth", LocalDate.now().minusYears(25)));
		userList.add(new User(++idCounter, "Reddy", LocalDate.now().minusYears(20)));
	}
	
	
	
	//p List<user> findAll()
	public List<User> findAll()
	{
		return userList;
	}
	
	//p User findOne(int userId)
	public User findOne(int userId)
	{
		for(User user:userList)
		{
			if(user.getId()== userId)
				return user;
		}
		return null;
	}

	//p User save(User user)
	public User save(User user)
	{
		user.setId(++idCounter);
		userList.add(user);		
		
		return user;
	}
	
	//p User delete(int userId)
	public User delete(int userId)
	{
		User deletedUser = null;
		for(User user:userList)
		{
			if(user.getId()== userId)
			{
				deletedUser = user;
				userList.remove(user);
				return deletedUser;
			}
		}
		return deletedUser;		
	}
	
	
	
	
}
