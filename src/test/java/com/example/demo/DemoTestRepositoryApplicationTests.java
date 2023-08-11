package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(value = "/application.properties")
class DemoTestRepositoryApplicationTests {

	@Test
	void contextLoads() {
	}

}
