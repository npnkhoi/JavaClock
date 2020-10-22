package com.example.javaclockbackend;

import com.example.javaclockbackend.controller.utils.ResponseObject;
import com.example.javaclockbackend.entity.User;
import com.example.javaclockbackend.repository.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // make the tests run in order specified below
class JavaclockBackendApplicationTests {
	public static final String USERNAME = "test";
	public static final String PASSWORD = "Acb524*$%";
	public static final String WRONG_PASSWORD = "A$";

	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	UserRepository userRepository;
	@Test
	void contextLoads() {
		assertThat(userRepository).isNotNull();
	}

	@Test
	@Order(1)
	void testSaveUser() {
		final User user = User.builder()
				.username(USERNAME)
				.password(PASSWORD)
				.name("Tester Agent")
				.build();

		User res = userRepository.save(user);
		assertThat(res).isNotNull();
	}

	@Test
	@Order(2)
	void findByUsername() {
		List<User> users = userRepository.findByUsername(USERNAME);
		assertThat(users).isNotEmpty();
		assertThat(users.get(0)).extracting(User::getUsername).isEqualTo(USERNAME);
	}

	@Test
	@Order(3)
	void testUserLogin() {
		final User user = User.builder()
				.username(USERNAME)
				.password(PASSWORD)
				.name("Tester Agent")
				.build();

		User res = userRepository.save(user);

		final User loginUser = User.builder()
				.username(USERNAME)
				.password(PASSWORD)
				.build();

		ResponseObject result = restTemplate.postForObject("http://localhost:8090/login",
				loginUser, ResponseObject.class);
		assertThat(result).extracting(ResponseObject::getMessage).isEqualTo("SUCCESS");
	}
}
