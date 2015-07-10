package org.hannes.pleer;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public interface Request<T> {

	/**
	 * Creates the HttpRequest to send to the Pleer servers
	 * 
	 * @return
	 * @throws PleerException
	 */
	public abstract HttpEntityEnclosingRequestBase create() throws Exception;

	/**
	 * Fills in the header information
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract List<NameValuePair> createHeader(List<NameValuePair> list) throws Exception;

	/**
	 * Get the enclosing type
	 * 
	 * @return
	 */
	public abstract Class<T> getEnclosingType();

}