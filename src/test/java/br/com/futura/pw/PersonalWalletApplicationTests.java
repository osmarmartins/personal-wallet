package br.com.futura.pw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class PersonalWalletApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void helloWorldTests() {
		assertEquals(1, 1);
	}

}
