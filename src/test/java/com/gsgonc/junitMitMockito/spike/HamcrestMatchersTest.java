package com.gsgonc.junitMitMockito.spike;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12,15,45);
		
		assertThat(numbers)
			.hasSize(3)
			.contains(12,15,45)
			.allMatch(x -> x > 10)
			.allMatch(x -> x < 100)
			.noneMatch(x -> x < 0);
		
		assertThat("").isEmpty();
		assertThat("ABCDE").contains("BC")
			.startsWith("ABC")
			.endsWith("CDE");
	}
}
