package net.simplon.springREST.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import net.simplon.springREST.domain.model.user.IUserRepository;
import net.simplon.springREST.domain.model.user.User;

@Configuration
@Slf4j
public class LoadDatabase {
	
	@Bean
	CommandLineRunner initDatabase(IUserRepository repository) {
		return args -> {
			log.info("Preloading" + repository.save(new User("bob","bob@mail.com")));
			log.info("Preloading" + repository.save(new User("jean","jean@mail.com")));
		};
	}
}
