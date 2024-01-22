package com.mudithakshura.backend;

import com.mudithakshura.backend.model.Role;
import com.mudithakshura.backend.model.User;
import com.mudithakshura.backend.repository.UserRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	private UserRepostitory userRepostitory;
	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);
	}

	public void run(String... args){
		User adminAccount = userRepostitory.findByRole(Role.ADMIN);

		if(adminAccount == null){
			User user = new User();

			user.setEmail("mudith.akshura23@gmail.com");
			user.setFirstname("mudith");
			user.setLastname("akshura");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepostitory.save(user);
		}
	}

}
