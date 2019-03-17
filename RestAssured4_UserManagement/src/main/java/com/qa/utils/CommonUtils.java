package com.qa.utils;

import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtils {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	//Utility to converting Json string to Hashmap
	public static HashMap<String, Object> jsonToMap(String jsonStr) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			if(jsonStr.contains("\n\n")){
				jsonStr = jsonStr.replace("\n\n", "\\n\\n" );
			}
			Object tempObject = mapper.readValue(jsonStr,new TypeReference<HashMap>(){});
			return (HashMap<String, Object>) tempObject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
