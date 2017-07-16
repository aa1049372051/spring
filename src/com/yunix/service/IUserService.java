package com.yunix.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yunix.models.User;

@Repository("userService")
public interface IUserService {
	public List<User> getUsers(User user);
	
	public Map findByPk(int id);
}
