package com.yunix.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunix.dao.IUserDao;
import com.yunix.models.User;
import com.yunix.service.IUserService;

@Service("userServiceImpl")
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	@Override
	public List<User> getUsers(User user) {
		// TODO Auto-generated method stub
		return userDao.getUsers(user);
	}
	@Override
	public Map findByPk(int id) {
		// TODO Auto-generated method stub
		return userDao.findByPk(id);
	}

}
