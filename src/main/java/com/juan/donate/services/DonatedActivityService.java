package com.juan.donate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juan.donate.models.DonatedActivity;
import com.juan.donate.repositories.DonatedActivityRepository;

@Service
public class DonatedActivityService {
	@Autowired
	private DonatedActivityRepository donatedActivityRepo;
	
//	READ ALL
	public List<DonatedActivity> allDonatedActivities(){
		return donatedActivityRepo.findAll();
	}
	
//	CREATE
	public DonatedActivity createdDonatedActivity(DonatedActivity donatedActivity) {
		return donatedActivityRepo.save(donatedActivity);
	}
	
//	READ ONE
	public DonatedActivity findDonatedActivity(Long id) {
		Optional <DonatedActivity> optionalDonatedActivity = donatedActivityRepo.findById(id);
		if(optionalDonatedActivity.isPresent()) {
			return optionalDonatedActivity.get();
		} else {
			return null;
		}
	}
	
//	UPDATE
	public DonatedActivity updatedDonatedActivity(DonatedActivity donatedActivity) {
		return donatedActivityRepo.save(donatedActivity);
	}
	
//	DELETE
	public void deleteDonatedActivity (Long id) {
		donatedActivityRepo.deleteById(id);
	}
}
