package com.juan.donate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.juan.donate.models.FreeActivity;

public interface FreeActivityRepository extends CrudRepository<FreeActivity, Long> {
	List<FreeActivity> findAll();
}
