package com.payco.banco;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BancoApplicationTests {

	@Test
	void contextLoads() {
		assertDoesNotThrow(() -> BancoApplication.main(new String[] {}));
	}

}
