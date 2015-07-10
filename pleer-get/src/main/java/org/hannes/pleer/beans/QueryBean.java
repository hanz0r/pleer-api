package org.hannes.pleer.beans;

import java.util.Map;

public class QueryBean {

	/**
	 * Indicates whether or not the query was a success
	 */
	private boolean success;
	
	/**
	 * The amount of tracks
	 */
	private int count;

	/**
	 * The tracks
	 */
	private Map<Integer, TrackBean> tracks;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Map<Integer, TrackBean> getTracks() {
		return tracks;
	}

	public void setTracks(Map<Integer, TrackBean> tracks) {
		this.tracks = tracks;
	}

}