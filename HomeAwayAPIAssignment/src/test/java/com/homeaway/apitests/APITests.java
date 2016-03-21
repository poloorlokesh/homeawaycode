package com.homeaway.apitests;

import java.util.Map;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.homeaway.apiutils.ConnectionUtils;
import com.homeaway.apiutils.Constants;
import com.homeaway.apiutils.UrlUtils;
import com.homeaway.testutils.JsonParser;

public class APITests {
	public static String stationID = null;

	@Test
	public void verifyStationExists() {
		String apiURL = UrlUtils.getNearestStationURL(Constants.INPUT_LOCATION);
		String responseString = ConnectionUtils.callAPI(apiURL);
		Map<String, String> resultMap = JsonParser.parseNearestResponseJson(responseString);
		stationID=resultMap.get(Constants.CITYCODEVALIDATION);
		Assert.assertNotNull("Validation failed " + Constants.CITYCODEVALIDATION + " does not exists in result",
				stationID);
	}

	@Test(dependsOnMethods = { "verifyStationExists" })
	public void verifyStationAddress() {
		String apiURL = UrlUtils.getStationIdURL(stationID);
		String responseString = ConnectionUtils.callAPI(apiURL);
		Map<String,String> stationDetails= JsonParser.parseStationJson(responseString);
		Assert.assertEquals(Constants.STREETVALIDATION, stationDetails.get(Constants.STREET));
		Assert.assertEquals(Constants.CITYVALIDATION, stationDetails.get(Constants.CITY));
		Assert.assertEquals(Constants.STATEVALIDATION, stationDetails.get(Constants.STATE));
		Assert.assertEquals(Constants.ZIPVALIDATION, stationDetails.get(Constants.ZIP));
		
	}

}
