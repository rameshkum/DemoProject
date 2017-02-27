package com.cybage.core;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSONObject detailsJson = new JSONObject();
		
		JSONArray jsonArray = new JSONArray();
		detailsJson.put("Id", "1990");	
		detailsJson.put("Company name", "Cybage Software Pvt Ltd");
		
		for( int i=1; i<6; i++){
			JSONObject json = new JSONObject();
			json.put("ID", "ID"+i);
			json.put("name", "name"+i);
			json.put("Salary", 10000*i);
			jsonArray.put(json);
		}
		
		detailsJson.put("employees", jsonArray);
		System.out.println(detailsJson.toString());
		
	}
}
