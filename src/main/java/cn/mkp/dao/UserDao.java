package cn.mkp.dao;

import cn.mkp.entity.User;

public interface UserDao {

	User getUserByUsername(String username);
}
