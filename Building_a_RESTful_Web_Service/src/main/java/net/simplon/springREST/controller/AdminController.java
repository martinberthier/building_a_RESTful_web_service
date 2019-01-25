package net.simplon.springREST.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import net.simplon.springREST.application.IFrontOfficeService;
import net.simplon.springREST.domain.model.user.User;



@Controller
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	IFrontOfficeService foService;
	
	
	//Adduser(Post avec requestMapping) url
	//@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	@PostMapping("/adduser")
	public User addUser(@RequestBody  User newUser) {

		return foService.addUser(newUser);
		
	}
	
	//Getuser(getavec pathvariablepour l’id)
	@GetMapping("/{id}")
	public User getUser(@PathVariable long id) {
		return foService.getUser(id);
	}
	
	//Getusers(get)
	@GetMapping("/getusers")
	public List<User> getUsers(){
		return foService.listerUsers();
	}
	
	//DeleteUser(Deleteavec pathvariablepour l’id)
	@DeleteMapping("/deleteuser/{id}")
	public void deleteUser(@PathVariable long id) {
		 foService.deleteUser(id);
	}
	
	//Updateuser(Put avec requestBody)
	@PutMapping("/updateuser")
	public void updateUser(@RequestBody User user) {
		foService.updateUser(user);
	}
	
}
