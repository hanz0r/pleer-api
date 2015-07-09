package org.hannes.pleer;

@FunctionalInterface
public interface Response<T> {

	/**
	 * 
	 * @return
	 * @throws PleerException
	 */
	public abstract T get() throws PleerException;

}