package com.gsgonc.junitMitMockito;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	private String actualResponse = "{\"quantity\":1,\"price\":100,\"name\":\"honey\",\"id\":1}";
			
	@Test
	public void jsonAssert_strictTrue() throws JSONException {
		String expectedResponse = "{\"quantity\":1,\"price\":100,\"name\":\"honey\",\"id\":1}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	
	@Test
	public void jsonAssert_strictFalse() throws JSONException {
		String expectedResponse = "{\"quantity\":1,\"price\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssert_withoutScapeChars() throws JSONException {
		String expectedResponse = "{quantity:1, price:100, name:honey, id:1}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
}
