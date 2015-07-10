package org.hannes.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.hannes.pleer.PleerException;
import org.hannes.pleer.PleerSession;
import org.hannes.pleer.beans.DownloadBean;
import org.hannes.pleer.beans.QueryBean;
import org.hannes.pleer.request.DownloadRequest;
import org.hannes.pleer.request.SearchRequest;

public class PleerTest {

	public static void main(String[] args) throws PleerException {
		PleerSession session = PleerSession.create();
		QueryBean query = session.request(new SearchRequest("john lennon"));

		System.out.println("Success: " + query.isSuccess());
		System.out.println("Count: " + query.getCount());
		System.out.println("Tracks");
		query.getTracks().values().forEach(System.out::println);
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		query.getTracks().values().forEach(bean -> {
			try {
				DownloadBean download_bean = session.request(new DownloadRequest(bean.getId()));
				service.submit(new DownloadThread(bean, download_bean.getDownloadLink()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
//		TrackBean[] tracks = pleer.request(new SearchRequest("john lennon"));
//		for (TrackBean track : tracks) {
//			System.out.println(track.getArtist() + " - " + track.getTrack());
//		}
//		
//		DownloadBean bean = pleer.request(new DownloadRequest("9899444bhP3"));
//		System.out.println(bean.getDownloadLink());
	}

}