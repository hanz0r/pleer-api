package org.hannes.pleer.beans;

import java.io.Serializable;

public class TrackBean implements Serializable {

	private static final long serialVersionUID = -4718103594955172969L;
	
	/**
	 * The track ID on the server
	 */
	private String id;
	
	/**
	 * The song's artist
	 */
	private String artist;
	
	/**
	 * The name of the song
	 */
	private String track;
	
	/**
	 * The song's length
	 */
	private int length;
	
	/**
	 * The bitrate of the track
	 */
	private String bitrate;
	
	/**
	 * The size of the file
	 */
	private int size;
	
	@Override
	public String toString() {
		return artist + " - " + track;
	}

	public String getId() {
		return id;
	}

	public void setId(String track_id) {
		this.id = track_id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getBitrate() {
		return bitrate;
	}

	public void setBitrate(String bitrate) {
		this.bitrate = bitrate;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}