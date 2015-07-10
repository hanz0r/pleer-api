package org.hannes.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

import org.hannes.pleer.beans.TrackBean;

public class DownloadThread implements Callable<File> {

	/**
	 * The song to be downloaded
	 */
	private final TrackBean song;
	
	/**
	 * The song url
	 */
	private final String url;

	public DownloadThread(TrackBean song, String url) {
		this.song = song;
		this.url = url;
	}

	@Override
	public File call() throws Exception {
		try {
				
			/*
			 * Create the file objects
			 */
			File file = new File(System.getProperty("user.home") + "/Music/" + song.getArtist() + " - " + song.getTrack() + ".mp3");
			
			if (file.exists()) {
				return file;
			}
			System.out.println("Downloading " + file.getPath() + " from " + url);
			
			/*
			 * Create the connection
			 */
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			ReadableByteChannel in_channel = Channels.newChannel(connection.getInputStream());
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			FileChannel out_channel = raf.getChannel();
			
			out_channel.transferFrom(in_channel, 0, connection.getContentLength());
			
			/*
			 * Close the file
			 */
			raf.close();
			
			/*
			 * Return the file
			 */
			System.out.println("downloaded");
			return file;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("wtf");
		throw new FileNotFoundException("File has not been found");
	}

}