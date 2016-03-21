package com.homeaway.apiutils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class ConnectionUtils {

	final static Logger logger = Logger.getLogger(ConnectionUtils.class);

	public static String callAPI(String url) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String jsonString = null;
		try {
			HttpGet getRequest = new HttpGet(url);
			// Set the API media type in http accept header
			getRequest.addHeader("accept", "application/json");
			// Send the request; It will immediately return the response in
			// HttpResponse object
			HttpResponse response = httpClient.execute(getRequest);
			jsonString = EntityUtils.toString(response.getEntity(), "application/json");
			
		} catch (Exception ex) {
			logger.error("Issue hitting the API " + ex.getMessage());
		}

		return jsonString;
	}

}
