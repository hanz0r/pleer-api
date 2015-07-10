package org.hannes.pleer.request;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.message.BasicNameValuePair;
import org.hannes.pleer.Request;
import org.hannes.pleer.beans.AccessToken;

public class AccessTokenRequest implements Request<AccessToken> {

	/**
	 * The URL to the method for the API
	 */
	private static final String GET_URL = "http://api.pleer.com/token.php";
	
	/**
	 * Application username
	 */
	private static final String USERNAME = "756580";
	
	/**
	 * Application password
	 */
	private static final String PASSWORD = "KA5BzVGB2hBFgT1qIPBv";

	@Override
	public List<NameValuePair> createHeader(List<NameValuePair> list) throws Exception {
		list.add(new BasicNameValuePair("grant_type", "client_credentials"));
		return list;
	}

	@Override
	public HttpEntityEnclosingRequestBase create() throws Exception {
		HttpPost request = new HttpPost(GET_URL);
		BasicScheme scheme = new BasicScheme();
		request.addHeader(scheme.authenticate(new UsernamePasswordCredentials(USERNAME, PASSWORD), request, null));
		return request;
	}

	@Override
	public Class<AccessToken> getEnclosingType() {
		return AccessToken.class;
	}
}