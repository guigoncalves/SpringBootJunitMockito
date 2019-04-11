package com.gsgonc.junitMitMockito.spike;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertJTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12,15,45);
		
		assertThat(numbers, hasSize(3));
		assertThat(numbers, hasItems(12,45));
		assertThat(numbers, everyItem(greaterThan(10)));
		assertThat(numbers, everyItem(lessThan(50)));

		assertThat("", isEmptyString());
		assertThat("ABCDE", startsWith("ABC"));
		assertThat("ABCDE", endsWith("CDE"));
	
	}
}
