package com.juan.donate.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juan.donate.models.DonatedActivity;
import com.juan.donate.models.FreeActivity;
import com.juan.donate.models.User;
import com.juan.donate.services.DonatedActivityService;
import com.juan.donate.services.FreeActivityService;
import com.juan.donate.services.UserService;

@Controller
public class MainController {
	@Autowired
	UserService userServ;
	@Autowired
	DonatedActivityService donatedActivityService;
	@Autowired 
	FreeActivityService freeActivityService;
	
//	==================================DONATED EVENT CONTROLLERS======================================
	
	
//	RENDER CREATE DONATED ACTIVITY PAGE
	@GetMapping("/new/donatedactivity")
	public String createdDonatedActivity(@ModelAttribute("newDonatedActivity") DonatedActivity donatedActivity,
			Model model, HttpSession sesh) {
		Long userId = (Long) sesh.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		} else {
			User loggedInUser = userServ.findOne(userId);
			model.addAttribute("loggedInUser", loggedInUser);
			return "createDonatedActivity.jsp";
		}
	}
	
//	POST METHOD CREATE DONATED ACTIVITY.
	@PostMapping("create/donatedActivity")
	public String create(@Valid @ModelAttribute("newDonatedActivity") DonatedActivity donatedActivity, BindingResult result, Model model, HttpSession sesh) {
		Long userId = (Long) sesh.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		} else {
			User loggedInUser = userServ.findOne(userId);
			model.addAttribute("loggedInUser", loggedInUser);
			if(result.hasErrors()) {
				return "createDonatedActivity.jsp";
			} else {
				donatedActivity.setUser(loggedInUser);
				donatedActivityService.createdDonatedActivity(donatedActivity);
				return "redirect:/home";
			}
		}
	}
	
//	SHOW SINGLE DONATED ACTIVITY
	@GetMapping("/activities/{id}")
	public String viewDonatedActivity(@PathVariable("id") Long id, Model model) {
		DonatedActivity donatedActivity = donatedActivityService.findDonatedActivity(id);
		model.addAttribute("donatedActivity", donatedActivity);
		return "showDonatedActivity.jsp";
	}
	
//	RENDER EDIT PAGE
	@RequestMapping("/activities/{id}/edit")
	public String editDonatedActivity(@PathVariable("id")Long id, Model model) {
		DonatedActivity donatedActivity = donatedActivityService.findDonatedActivity(id);
		model.addAttribute("donatedActivity", donatedActivity);
		return "editDonatedActivity.jsp";
	}
	
//	POST METHOD FOR EDIT PAGE
	@PutMapping("/edit/donatedActivity/{id}")
	public String updateDonatedActivity(@Valid @ModelAttribute("donatedActivity") DonatedActivity donatedActivity, BindingResult result, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if(result.hasErrors()) {
			return "editDonatedActivity.jsp";
		} else {
			User loggedInUser = userServ.findOne(userId);
			model.addAttribute("loggedInUser", loggedInUser);
			donatedActivity.setUser(loggedInUser);
			donatedActivityService.updatedDonatedActivity(donatedActivity);
			return "redirect:/home";
		}
	}
	
//	DELETE DONATED EVENT
	@RequestMapping("/delete/{id}")
	public String deleteDonatedEvent(@PathVariable("id") Long id) {
		donatedActivityService.deleteDonatedActivity(id);
		return "redirect:/home";
	}
	
//	==================================FREE EVENT CONTROLLERS======================================

//	RENDER CREATE DONATED ACTIVITY PAGE
	@GetMapping("/new/FreeActivity")
	public String createdFreeActivity(@ModelAttribute("newFreeActivity") FreeActivity freeActivity,
			Model model, HttpSession sesh) {
		Long userId = (Long) sesh.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		} else {
			User loggedInUser = userServ.findOne(userId);
			model.addAttribute("loggedInUser", loggedInUser);
			return "createFreeActivity.jsp";
		}
	}
	
//	POST METHOD CREATE DONATED ACTIVITY.
	@PostMapping("/create/freeActivity")
	public String create(@Valid @ModelAttribute("newFreeActivity") FreeActivity freeActivity, BindingResult result, Model model, HttpSession sesh) {
		Long userId = (Long) sesh.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		} else {
			User loggedInUser = userServ.findOne(userId);
			model.addAttribute("loggedInUser", loggedInUser);
			if(result.hasErrors()) {
				return "createFreeActivity.jsp";
			} else {
				freeActivity.setUser(loggedInUser);
				freeActivityService.createdFreeActivity(freeActivity);
				return "redirect:/home";
			}
		}
	}
	
//	SHOW SINGLE DONATED ACTIVITY
	@GetMapping("/free/activities/{id}")
	public String viewFreeActivity(@PathVariable("id") Long id, Model model) {
		FreeActivity freeActivity = freeActivityService.findFreeActivity(id);
		model.addAttribute("freeActivity", freeActivity);
		return "showFreeActivity.jsp";
	}
	
//	RENDER EDIT PAGE
	@RequestMapping("/free/activities/{id}/edit")
	public String editFreeActivity(@PathVariable("id")Long id, Model model) {
		FreeActivity freeActivity = freeActivityService.findFreeActivity(id);
		model.addAttribute("freeActivity", freeActivity);
		return "editFreeActivity.jsp";
	}
	
//	POST METHOD FOR EDIT PAGE
	@PutMapping("/edit/freeActivity/{id}")
	public String updateFreeActivity(@Valid @ModelAttribute("freeActivity") FreeActivity freeActivity, BindingResult result, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if(result.hasErrors()) {
			return "editFreeActivity.jsp";
		} else {
			User loggedInUser = userServ.findOne(userId);
			model.addAttribute("loggedInUser", loggedInUser);
			freeActivity.setUser(loggedInUser);
			freeActivityService.updatedFreeActivity(freeActivity);
			return "redirect:/home";
		}
	}
	
//	DELETE DONATED EVENT
	@RequestMapping("/free/delete/{id}")
	public String deleteFreeEvent(@PathVariable("id") Long id) {
		freeActivityService.deleteFreeActivity(id);
		return "redirect:/home";
	}
}
