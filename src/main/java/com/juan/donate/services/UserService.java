package com.juan.donate.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.juan.donate.models.LoginUser;
import com.juan.donate.models.User;
import com.juan.donate.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	public User register(User newUser, BindingResult result) {
//		Reject if the email is taken (present in the db)
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "registerErrors", "This email is taken");
		}
//		Reject if the passwords don't match with confirm
		if(!newUser.getPassword().equals(newUser.getConfirm())){
			result.rejectValue("confirm", "registerErrors", "Confirm password must match password.");
		}
//		Return null if result has errors
		if(result.hasErrors()) {
			return null;
		} else {
//			Hash and set password in db along with user
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
//			save user now that password is hashed
			return userRepo.save(newUser);
		}
	}
	
	public User login(LoginUser newLoginUser, BindingResult result) {
//		Find the user in the DB
		Optional<User> potentialUser = userRepo.findByEmail(newLoginUser.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "loginError", "Email not found");
		} else {
			User user = potentialUser.get();
//			Reject if BCrypt pass match fails
			if(!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
				result.rejectValue("password", "loginError", "Invalid Password");
			} 
			if(result.hasErrors()) {
				return null;
			} else {
				return user;
			}
		}
		
		return null;
	}
	
//	find one
	public User findOne(Long id) {
		Optional<User> potentialUser = userRepo.findById(id);
		if (potentialUser.isPresent()) {
			return potentialUser.get();
		} else {
			return null;
		}
	}
	
//	update user
	public User update(User u) {
		return userRepo.save(u);
	}
}
