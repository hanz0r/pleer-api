package org.hannes.pleer.request;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.hannes.pleer.Request;
import org.hannes.pleer.beans.DownloadBean;

/**
 * Creates the request to receive a download link from the server
 * 
 * @author Red
 */
public class DownloadRequest implements Request<DownloadBean> {

	/**
	 * The URL to the method for the API
	 */
	private static final String GET_URL = "http://api.pleer.com/index.php";

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
	public HttpEntityEnclosingRequestBase create() throws Exception {
		return new HttpPost(GET_URL);
	}

	@Override
	public Class<DownloadBean> getEnclosingType() {
		return DownloadBean.class;
	}

	@Override
	public List<NameValuePair> createHeader(List<NameValuePair> list) throws Exception {
		list.add(new BasicNameValuePair("method", "tracks_get_download_link"));
		list.add(new BasicNameValuePair("track_id", song_id));
		return list;
	}

}