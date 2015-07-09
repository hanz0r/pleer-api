package org.hannes.pleer.beans;

import java.io.Serializable;

public class DownloadBean implements Serializable {
	
	private static final long serialVersionUID = 9015775226013163235L;
	
	/**
	 * Indicates whether or not the bean was succesfully downloaded
	 */
	private boolean success;
	
	/**
	 * The type of object returned
	 */
	private String residue_type;
	
	/**
	 * Junk
	 */
	private int residue;
	
	/**
	 * Junk
	 */
	private String residue_human;
	
	/**
	 * Junk
	 */
	private int battery_charge;
	
	/**
	 * Download link to the mp3 file
	 */
	private String track_link;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getResidue_type() {
		return residue_type;
	}

	public void setResidue_type(String residue_type) {
		this.residue_type = residue_type;
	}

	public int getResidue() {
		return residue;
	}

	public void setResidue(int residue) {
		this.residue = residue;
	}

	public String getResidue_human() {
		return residue_human;
	}

	public void setResidue_human(String residue_human) {
		this.residue_human = residue_human;
	}

	public int getBattery_charge() {
		return battery_charge;
	}

	public void setBattery_charge(int battery_charge) {
		this.battery_charge = battery_charge;
	}

	public String getDownloadLink() {
		return track_link;
	}

	public void setTrack_link(String track_link) {
		this.track_link = track_link;
	}
	
}