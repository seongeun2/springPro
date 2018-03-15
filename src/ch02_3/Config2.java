package ch02_3;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch02.AuthFailLogger;
import ch02.AuthenticationService;
import ch02.PasswordChangeService;
import ch02.User;
import ch02.UserRepository;

@Configuration
public class Config2 {
	@Bean
	public User user1() {
		return new User("bkchoi", "1234");
	}
	@Bean(name = "user2")
	public User user() {
		return new User("madvirus", "qwer");
	}
	@Bean
	public UserRepository userRepository() {
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(), user()));
		return userRepo;
	}
}
