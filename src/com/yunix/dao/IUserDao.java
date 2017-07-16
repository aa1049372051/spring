package com.yunix.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yunix.models.User;

@Repository("userDao")
public interface IUserDao {

	public List<User> getUsers(User user);

	public Map findByPk(int id);
}
