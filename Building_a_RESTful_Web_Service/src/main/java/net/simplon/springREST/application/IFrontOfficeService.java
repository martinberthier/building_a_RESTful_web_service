package net.simplon.springREST.application;

import java.util.List;

import net.simplon.springREST.application.impl.FrontOfficeService;
import net.simplon.springREST.domain.model.user.*;

public interface IFrontOfficeService {

	List<User> listerUsers();

	User addUser(User user);

	User getUser(long id);

	void deleteUser(long id);

	void updateUser(User user);

}
