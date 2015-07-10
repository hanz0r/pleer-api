package org.hannes.pleer.request;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.hannes.pleer.Request;
import org.hannes.pleer.beans.QueryBean;

public class SearchRequest implements Request<QueryBean> {

	/**
	 * The URL to the method for the API
	 */
	private static final String GET_URL = "http://api.pleer.com/index.php";

	/**
	 * The query string
	 */
	private final String query;
	
	/**
	 * The quality of the search results
	 */
	private final Quality quality;

	public SearchRequest(String query) {
		this (query, Quality.ALL);
	}

	public SearchRequest(String query, Quality quality) {
		this.query = query;
		this.quality = quality;
	}

	@Override
	public List<NameValuePair> createHeader(List<NameValuePair> list) throws Exception {
		list.add(new BasicNameValuePair("method", "tracks_search"));
		list.add(new BasicNameValuePair("query", query));
		list.add(new BasicNameValuePair("quality", quality.toString().toLowerCase()));
		return list;
	}

	@Override
	public HttpEntityEnclosingRequestBase create() throws Exception {
		return new HttpPost(GET_URL);
	}

	@Override
	public Class<QueryBean> getEnclosingType() {
		return QueryBean.class;
	}

	/**
	 * Song quality of resultset
	 * 
	 * @author user104
	 *
	 */
	public static enum Quality {
		ALL, BAD, GOOD, BEST;
	}

}