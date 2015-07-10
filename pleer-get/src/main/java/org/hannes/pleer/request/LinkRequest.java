package org.hannes.pleer.request;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.hannes.pleer.Request;
import org.hannes.pleer.beans.LinkBean;

public class LinkRequest implements Request<LinkBean> {

	/**
	 * The URL to the method for the API
	 */
	private static final String GET_URL = "http://pleer.com/site_api/files/get_url";

	private final String id;

	public LinkRequest(String id) {
		this.id = id;
	}

	@Override
	public HttpEntityEnclosingRequestBase create() throws Exception {
		return new HttpPost(GET_URL);
	}

	@Override
	public List<NameValuePair> createHeader(List<NameValuePair> list) throws Exception {
		list.clear();
		list.add(new BasicNameValuePair("id", id));
		list.add(new BasicNameValuePair("action", "play"));
		return list;
	}

	@Override
	public Class<LinkBean> getEnclosingType() {
		return LinkBean.class;
	}

}