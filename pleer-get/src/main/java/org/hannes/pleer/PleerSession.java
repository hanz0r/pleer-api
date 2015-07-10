package org.hannes.pleer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.hannes.pleer.beans.AccessToken;
import org.hannes.pleer.request.AccessTokenRequest;

import com.google.gson.Gson;

public class PleerSession {

	/**
	 * The GSON object
	 */
	private final Gson gson;
	
	/**
	 * The http client object
	 */
	private final HttpClient client;
	
	/**
	 * The access token
	 */
	private AccessToken token;

	/**
	 * Create a Pleer object with a default http client and a standard gson object
	 */
	private PleerSession() {
		this (new Gson(), HttpClients.createDefault());
	}

	/**
	 * Create a Pleer object with the given gson and HttpClient objects provided by the user
	 * 
	 * @param gson
	 * @param client
	 */
	private PleerSession(Gson gson, HttpClient client) {
		this.gson = gson;
		this.client = client;
	}

	/**
	 * Create a pleer session
	 * 
	 * @return
	 * @throws PleerException
	 */
	public static PleerSession create() throws PleerException {
		PleerSession pleer = new PleerSession();
		pleer.token = pleer.request(new AccessTokenRequest());
		return pleer;
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws PleerException
	 */
	public <T> T request(Request<T> request) throws PleerException {
		try {
			HttpEntityEnclosingRequestBase http_request = request.create();
			
			/*
			 * Create the default header
			 */
			List<NameValuePair> header = new ArrayList<>();
			header.add(new BasicNameValuePair("Accept", "*/*"));
			header.add(new BasicNameValuePair("Cache-Control", "no-cache"));
			header.add(new BasicNameValuePair("Authorization", "Basic Og=="));
			header.add(new BasicNameValuePair("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
			
			/*
			 * Add the access token if it is not null
			 */
			if (token != null) {
				header.add(new BasicNameValuePair("access_token", token.getAccessToken()));
			}
			
			/*
			 * Fill in the header with the request's specific arguments
			 */
			http_request.setEntity(new UrlEncodedFormEntity(request.createHeader(header)));
			
			/*
			 * Send the request to the client
			 */
			HttpResponse response = client.execute(http_request);
			
			/*
			 * Parse the JSON response into the request's enclosing type
			 */
			String json = read(response.getEntity());
			System.out.println(json);
			return gson.fromJson(json, request.getEnclosingType());
		} catch (Exception ex) {
			throw new PleerException(ex);
		}
	}

	/**
	 * Returns the entity's contents as a String
	 * 
	 * @param entity
	 * @return
	 * @throws UnsupportedOperationException
	 * @throws IOException
	 */
	private String read(HttpEntity entity) throws UnsupportedOperationException, IOException {
		return IOUtils.toString(entity.getContent());
	}

}