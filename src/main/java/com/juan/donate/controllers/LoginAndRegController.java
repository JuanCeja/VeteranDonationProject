package com.juan.donate.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juan.donate.models.DonatedActivity;
import com.juan.donate.models.FreeActivity;
import com.juan.donate.models.LoginUser;
import com.juan.donate.models.User;
import com.juan.donate.services.DonatedActivityService;
import com.juan.donate.services.FreeActivityService;
import com.juan.donate.services.UserService;

@Controller
public class LoginAndRegController {

	@Autowired
	UserService userServ;
	@Autowired
	DonatedActivityService donatedActivityService;
	@Autowired
	FreeActivityService freeActivityService;

//	render login and registration page
	@GetMapping("/")
	public String index(Model model) {

		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}

//	Register new user
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession sesh) {
//	Execute the service to Register FIRST!
		userServ.register(newUser, result);
//	Then check for errors
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		} else {
			sesh.setAttribute("user_id", newUser.getId());
			return "redirect:/home";
		}
	}

//	Login User
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession sesh) {
		User user = userServ.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		} else {
			sesh.setAttribute("user_id", user.getId());
			return "redirect:/home";
		}
	}

//	HOME ROUTE
	@RequestMapping("/home")
	public String home(HttpSession s, Model m) {
//		retrieve the user from session
		Long userId = (Long) s.getAttribute("user_id");
//		check if userId is null
		if (userId == null) {
			return "redirect:/";
		} else {
////			go to the db to retrieve the user using the id from session
			User thisUser = userServ.findOne(userId);
			m.addAttribute("thisUser", thisUser);		
			List<DonatedActivity> donatedActivities = donatedActivityService.allDonatedActivities();
			m.addAttribute("donatedActivities", donatedActivities);
			List<FreeActivity> freeActivities = freeActivityService.allFreeActivities();
			m.addAttribute("freeActivities", freeActivities);

			return "home.jsp";
		}
	}


	//	Logout
	@GetMapping("/logout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "redirect:/";
	}
}
