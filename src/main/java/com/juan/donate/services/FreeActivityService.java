package com.juan.donate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juan.donate.models.FreeActivity;
import com.juan.donate.repositories.FreeActivityRepository;

@Service
public class FreeActivityService {
	@Autowired
	private FreeActivityRepository freeActivityRepo;
	
//	READ ALL
	public List<FreeActivity> allFreeActivities(){
		return freeActivityRepo.findAll();
		}
	
//	CREATE
	public FreeActivity createdFreeActivity(FreeActivity freeActivity) {
		return freeActivityRepo.save(freeActivity);
	}
	
//	READ ONE
	public FreeActivity findFreeActivity(Long id) {
		Optional <FreeActivity> optionalFreeActivity = freeActivityRepo.findById(id);
		if(optionalFreeActivity.isPresent()) {
			return optionalFreeActivity.get();
		} else {
			return null;
		}
	}
	
//	UPDATE
	public FreeActivity updatedFreeActivity(FreeActivity freeActivity) {
		return freeActivityRepo.save(freeActivity);
	}
	
//	DELETE
	public void deleteFreeActivity (Long id) {
		freeActivityRepo.deleteById(id);
	}
}
