package net.simplon.springREST.domain.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private long id;
	
	@NotEmpty
	//@Size(min = 1, max = 20)
	//@Column(nullable = false, unique = true)
	@Getter
	@Setter
	private String login;
	
	//@Email
	//@Column(unique = true)
	@Getter
	@Setter
	private String email;

	protected User() {
		super();
	}

	public User(@NotEmpty @Size(min = 1, max = 20) String login, @Email String email) {
		super();
		this.login = login;
		this.email = email;
	}
	
	
	
	
}
