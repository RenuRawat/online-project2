package com.collaborate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.Dao.UserDao;
import com.collaborate.Model.User;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserDao userDao;

public boolean registerUser(User user) {
	
	return userDao.registerUser(user);
	
}

@Override
public boolean isUsernameValid(String username) {
	
	return userDao.isUsernameValid(username);
}

@Override
public boolean isEmailValid(String email) {
	
	return userDao.isEmailValid(email);
}






}