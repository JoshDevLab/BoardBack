package com.josh.BoardBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardBackApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args -> {
//			userService.saveRole((new Role(null, "ROLE_USER")));
//			userService.saveRole((new Role(null, "ROLE_MANAGER")));
//			userService.saveRole((new Role(null, "ROLE_ADMIN")));
//			userService.saveRole((new Role(null, "ROLE_SUPER_ADMIN")));
//
//			userService.saveUser(new User(null, "Josh", "josh", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "장진영", "redpwon", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "최현우", "devchoi", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "정찬혁", "chanh", "1234", new ArrayList<>()));
//
//			userService.addRoleToUser("josh", "ROLE_SUPER_ADMIN");
//			userService.addRoleToUser("josh", "ROLE_ADMIN");
//			userService.addRoleToUser("josh", "ROLE_MANAGER");
//			userService.addRoleToUser("devchoi", "ROLE_USER");
//			userService.addRoleToUser("redpwon", "ROLE_MANAGER");
//			userService.addRoleToUser("chanh", "ROLE_ADMIN");
//			userService.addRoleToUser("chanh", "ROLE_MANAGER");
//		};
//	}


}
