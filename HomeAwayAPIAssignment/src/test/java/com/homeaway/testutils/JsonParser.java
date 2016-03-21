package com.homeaway.testutils;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.homeaway.apiutils.Constants;

public class JsonParser {
	
	public static Map<String,String> parseNearestResponseJson(String jsonStr)
	{
		Map<String,String> fuelStations= new HashMap<String,String>();
		org.json.JSONObject jsonObject = new org.json.JSONObject(jsonStr);
        org.json.JSONArray jsonArray = jsonObject.getJSONArray("fuel_stations");
        for(int i=0 ;i <jsonArray.length(); i++)
        {
        	JSONObject innerObject = (JSONObject) jsonArray.getJSONObject(i);
        	String stationName= innerObject.get("station_name").toString().trim();
        	String stationID= innerObject.get("id").toString().trim();
        	fuelStations.put(stationName, stationID);
        }
      return fuelStations;  
	}
	
	public static Map<String,String> parseStationJson(String jsonStr)
	{
		Map<String,String> stationDetails= new HashMap<String,String>();
		org.json.JSONObject superJsonObject = new org.json.JSONObject(jsonStr);
		org.json.JSONObject jsonObject = superJsonObject.getJSONObject("alt_fuel_station");
		String street= (String) jsonObject.get("street_address");
		stationDetails.put(Constants.STREET, street);
		String city= (String) jsonObject.get("city");
		stationDetails.put(Constants.CITY, city);
		String state= (String) jsonObject.get("state");
		stationDetails.put(Constants.STATE, state);
		String zip= (String) jsonObject.get("zip");
		stationDetails.put(Constants.ZIP, zip);
		return stationDetails;
		
	}

}
