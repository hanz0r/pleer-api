package org.hannes.pleer;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Pleer {

	/**
	 * The GSON object
	 */
	private final Gson gson;
	
	/**
	 * The http client object
	 */
	private final HttpClient client;

	/**
	 * Create a Pleer object with a default http client and a standard gson object
	 */
	public Pleer() {
		this (new Gson(), HttpClients.createDefault());
	}

	/**
	 * Create a Pleer object with the given gson and HttpClient objects provided by the user
	 * 
	 * @param gson
	 * @param client
	 */
	public Pleer(Gson gson, HttpClient client) {
		this.gson = gson;
		this.client = client;
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @throws PleerException
	 */
	public <T> T request(Request<T> request) throws PleerException {
		try {
			HttpResponse response = client.execute(request.create());
			return gson.fromJson(read(response.getEntity()), request.getEnclosingType());
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