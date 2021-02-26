package com.learning.supermarket.freshmarket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.learning.supermarket.freshmarket.entity.Contact;
import com.learning.supermarket.freshmarket.entity.User;
import com.learning.supermarket.freshmarket.service.ContactService;
import com.learning.supermarket.freshmarket.service.ProductService;
import com.learning.supermarket.freshmarket.service.UserService;

@RestController
public class Login {
	@Autowired
	UserService userService;
	@Autowired
	ContactService conatctService;
	
	@GetMapping(value = { "/", "/login" })
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login"); //this will try to find the login.html
		return mv;
	}
	
	@GetMapping("/home")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("userName", "welcome User");
		return mv;
	}
	@GetMapping("/admin/home")
	public ModelAndView getAdminHomePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/adminHome");
		mv.addObject("userName", "welcome Admin");
		return mv;
	}
	@GetMapping("/registration")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView();
		//UserController userController = new UserController();
		User user = new User();
		user.setUserName("xyz");
		mv.addObject("user", user);
		mv.setViewName("registration");
		return mv;
	}
	@PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
       
        User userExists = userService.findUserByUserName(user.getUserName());
        if (userExists != null) {
            bindingResult.rejectValue("userName", "error.user","There is already a user registered with the user name provided");
       
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.addNewUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }
	
	@GetMapping("/contact-us")
	public ModelAndView getContactUs() {
		ModelAndView mv = new ModelAndView();
		Contact contact =  new Contact();
		contact.setFirstName("xyz");
		mv.addObject("contact", contact);
		mv.setViewName("contact");
		return mv;
	}
	
	@PostMapping("/contact-us")
	public ModelAndView addContactInfo(Contact contact, BindingResult bindingResult) {
	    ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("contact");
        } else {
            conatctService.addContact(contact);
            modelAndView.addObject("successMessage", "successfully add your contact");
            modelAndView.addObject("conatct", new Contact());
            modelAndView.setViewName("contact");
        }   
        return modelAndView;
	} 
	
	@GetMapping("/about-us")
	public ModelAndView getAboutUs() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("about");
		return mv;
	}
	
	@GetMapping("/up-coming")
	public ModelAndView getUpComing() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upComing");
		return mv;
	}
	
	@GetMapping("/up-coming-products")
	public ModelAndView getUpComingProducts() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upComingProducts");
		return mv;
	}

}
