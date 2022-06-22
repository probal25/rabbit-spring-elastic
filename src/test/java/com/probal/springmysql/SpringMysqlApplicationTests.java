package com.probal.springmysql;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
		properties = {"spring.cloud.config.enabled=false"}
)
class SpringMysqlApplicationTests {

	@Test
	void contextLoads() {
	}

}
