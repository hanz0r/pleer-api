package org.hannes.pleer;

import org.apache.http.client.methods.HttpUriRequest;

public interface Request<T> {

	/**
	 * Creates the HttpRequest to send to the Pleer servers
	 * 
	 * @return
	 * @throws PleerException
	 */
	public abstract HttpUriRequest create() throws Exception;

	/**
	 * Get the enclosing type
	 * 
	 * @return
	 */
	public abstract Class<T> getEnclosingType();

}