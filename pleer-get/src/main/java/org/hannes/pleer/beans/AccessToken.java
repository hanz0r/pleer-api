package org.hannes.pleer.beans;

import java.io.Serializable;

public class AccessToken implements Serializable {
	
	private static final long serialVersionUID = -9085196690974141791L;

	/**
	 * The token id
	 */
	private String access_token;
	
	/**
	 * How long until the token expires (in seconds)
	 */
	private long expires_in;
	
	/**
	 * The token type
	 */
	private String token_type;
	
	/**
	 * The range of the scope
	 */
	private Object scope;

	public String getAccessToken() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public Object getScope() {
		return scope;
	}

	public void setScope(Object scope) {
		this.scope = scope;
	}
	
	
}