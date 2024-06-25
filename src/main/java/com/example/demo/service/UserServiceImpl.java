package com.example.demo.service;

//package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserMapper;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    //private UserRepository userRepository = new UserRepository();
	
	@Autowired
	private UserMapper userMapper;
    
    @Override
    public List<User> getUserList() {
        List<User> users =  userMapper.findAll();
        return users;
    }

    @Override
    public User findUserById(long id) {
        return userMapper.findUserById(id);
    }

    public User findUserByuserId(String userId) {
    	return userMapper.findUserByuserId(userId);
    }
    
	@Override
	public void save(User user) {
		userMapper.save(user);
	}

    @Override
    public void edit(User user) {
        userMapper.edit(user);
    }

    @Override
    public void delete(long id) {
        userMapper.delete(id);
    }
    

}
