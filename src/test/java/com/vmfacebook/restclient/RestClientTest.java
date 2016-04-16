package com.vmfacebook.restclient;

import java.util.List;

import org.junit.Test;

import com.restfb.types.User;
import com.vmfacebook.restclientimpl.RestFBClientImpl;

import junit.framework.TestCase;

public class RestClientTest extends TestCase {
	// Set this auth token before running the tests.
	String authToken = "";

	@Test
	public void testGetFriendList() {
		RestFBClient restClient = new RestFBClientImpl(authToken);
		List<User> friendList = restClient.getFriendList();
		
		for (User user : friendList) {
			System.out.println(user.getId() + ":" + user.getName() + ":" + user.getGender());
			List<String> urls = restClient.getProfilePhotosUrl(user);
			for (String url : urls ) {
				System.out.println(url);
			}
		}
	}
}
