package com.gsgonc.junitMitMockito.util;

import java.util.Arrays;

public class MathUtils {

	public Integer calculateSum(int[] data) {
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
}
