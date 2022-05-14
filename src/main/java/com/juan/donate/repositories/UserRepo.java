package com.juan.donate.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.juan.donate.models.User;

public interface UserRepo extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);

	List<User> findAll();
}
