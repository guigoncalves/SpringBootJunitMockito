package com.gsgonc.junitMitMockito.spike;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void learning() {
		String responseFromService = "[" + 
				"{\"id\":1001, \"name\":\"eraser\"}," + 
				"{\"id\":1002, \"name\":\"knife\"}," + 
				"{\"id\":1003, \"name\":\"fork\"}" + 
				"]";
	
		DocumentContext context = JsonPath.parse(responseFromService);
		
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<Integer> ids = context.read("$..id");
		assertThat(ids).containsExactly(1001,1002,1003);

		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:1]").toString());
		System.out.println(context.read("$.[?(@.name=='eraser')]").toString());
	}
}
