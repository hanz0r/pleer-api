package org.hannes.pleer.beans;

import java.io.Serializable;

public class DownloadBean implements Serializable {
	
	private static final long serialVersionUID = 9015775226013163235L;
	
	/**
	 * Indicates whether or not the bean was succesfully downloaded
	 */
	private boolean success;
	
	/**
	 * Download link to the mp3 file
	 */
	private String url;

	public boolean isSuccess() {
		return success;
	}

	public String getDownloadLink() {
		return url;
	}

	public void setTrack_link(String track_link) {
		this.url = track_link;
	}
	
}