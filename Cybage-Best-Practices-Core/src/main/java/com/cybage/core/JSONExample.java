package com.cybage.core;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JSONObject detailsJson = new JSONObject();
		
		JSONArray jsonArray = new JSONArray();
		detailsJson.put("Id", "1990");	
		detailsJson.put("Company name", "Cybage Software Pvt Ltd");
		
		for( int i=1; i<6; i++){
			JSONObject json = new JSONObject();
			json.put("Id", "ID_"+i);
			json.put("Name", "name"+i);
			json.put("Salary", 10000*i);
			jsonArray.put(json);
		}
		
		detailsJson.put("Employees", jsonArray);
		System.out.println(detailsJson.toString());
		
	}
}
