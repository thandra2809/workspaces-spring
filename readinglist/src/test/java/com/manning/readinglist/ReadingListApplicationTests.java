package com.manning.readinglist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringBootTest
class ReadingListApplicationTests {

	@Test
	void contextLoads() {
		assertEquals("Test-1",2, 2);
	}

	@Test
	void contextLoadsNegative() {
		assertEquals("Test-2",2, 2);
	}

}
