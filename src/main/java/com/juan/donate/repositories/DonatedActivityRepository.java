package com.juan.donate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.juan.donate.models.DonatedActivity;

public interface DonatedActivityRepository extends CrudRepository<DonatedActivity, Long> {
	List<DonatedActivity> findAll();
}
