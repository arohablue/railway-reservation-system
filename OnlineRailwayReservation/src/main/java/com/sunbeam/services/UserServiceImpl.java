package com.sunbeam.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.entities.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao uDao;
	
	
	@Override
	public User findByEmail(String email) {
		
		return uDao.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		
		return uDao.findAll();
	}

	@Override
	public User save(User user) {
		return uDao.save(user);
	}



	@Override
	public User authenticate(String email, String password) {
		User user = findByEmail(email);
	
		if(user!=null  && user.getPassword().equals(password)) {
//			if (user.getRole().equals("user")) {
//				return user;
//			}
//			else if (user.getRole().equals("admin")) {
//				return user;
//		}
//			else if(user.getRole().equals("agent")){
//				return user;
//			}
			return user;
		}
			
			
		return null;
	}

	@Override
	public User update(User user) {
		return uDao.save(user);
	}

	@Override
	public User findById(int id) {
		Optional<User> user= uDao.findById(id);
		return user.orElse(null);
	}

	@Override
	public Boolean deleteById(int id) {
		if(uDao.existsById(id)) {
			uDao.deleteById(id);
			return true;
		}
		return false;
	}


//	@Override
//	public User findById(int id) {
//		
//		return uDao.findById(id);
//	}

}
