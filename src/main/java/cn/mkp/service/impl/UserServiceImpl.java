package cn.mkp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mkp.dao.UserDao;
import cn.mkp.entity.User;
import cn.mkp.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	public User getUserByUsername(String username) {
		User user = userDao.getUserByUsername(username);
		return user;
	}

}
