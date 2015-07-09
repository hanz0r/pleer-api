package org.hannes.pleer;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.hannes.pleer.beans.DownloadBean;

/**
 * Creates the request to receive a download link from the server
 * 
 * @author Red
 */
public class DownloadRequest implements Request<DownloadBean> {

	private static final String GET_URL = "http://pleer.com/site_api/files/get_url";

	/**
	 * The id of the song
	 */
	private final String song_id;

	/**
	 * Create a new request to the download link for a given song
	 * 
	 * 9899444bhP3
	 * 
	 * @param song_id
	 */
	public DownloadRequest(String song_id) {
		this.song_id = song_id;
	}

	@Override
	public HttpUriRequest create() throws Exception {
		HttpPost request = new HttpPost(GET_URL);
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("id", song_id));
		nvps.add(new BasicNameValuePair("action", "play"));
		request.setEntity(new UrlEncodedFormEntity(nvps));
		return request;
	}

	@Override
	public Class<DownloadBean> getEnclosingType() {
		return DownloadBean.class;
	}

}