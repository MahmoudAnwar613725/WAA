package edu.miu.restful;

import edu.miu.restful.entity.Role;
import edu.miu.restful.entity.User;
import edu.miu.restful.repo.RoleRepo;
import edu.miu.restful.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestfulApplication implements CommandLineRunner {
	@Autowired
	UserRepo userRepo;
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(RestfulApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		Role role1 = new Role(1, "ROLE_ADMIN");
		Role role2 = new Role(2, "ROLE_USER");

		roleRepo.save(role1);roleRepo.save(role2);

		List<Role> rolesList = new ArrayList<>();
		rolesList.add(role1);

 		User userData = new User(1,"test","email",passwordEncoder.encode("123"),rolesList,null,null,null );
		userRepo.save(userData);
	}
}
