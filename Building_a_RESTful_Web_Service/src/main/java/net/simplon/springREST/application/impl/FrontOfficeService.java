package net.simplon.springREST.application.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.simplon.springREST.application.IFrontOfficeService;
import net.simplon.springREST.domain.model.user.IUserRepository;
import net.simplon.springREST.domain.model.user.User;

@Service
public class FrontOfficeService implements IFrontOfficeService{
	
	@Autowired
	IUserRepository users;
	
	@Override
	public List<User> listerUsers() {

		return users.findAll();
	}
	
	@Override
	public User addUser(User user) {
		return users.save(user);
	}
	
	@Override
	public User getUser(long id) {

		Optional<User> toFind = users.findById(id);

		if (!toFind.isPresent())
			return null;
		return users.findById(id).get();
	}

	@Override
	public void deleteUser(long id) {
		users.deleteById(id);
	}
	
	@Override
	public void updateUser(User user) {

		Optional<User> userToUpdate = users.findById(user.getId());

		User userModif = userToUpdate.get();

		userModif.setEmail(user.getEmail());
		userModif.setLogin(user.getLogin());
		users.save(userModif);

	}
}
