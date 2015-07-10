package org.hannes.test;

import java.util.Scanner;

import org.hannes.pleer.PleerException;
import org.hannes.pleer.PleerSession;
import org.hannes.pleer.beans.DownloadBean;
import org.hannes.pleer.beans.QueryBean;
import org.hannes.pleer.beans.TrackBean;
import org.hannes.pleer.request.DownloadRequest;
import org.hannes.pleer.request.SearchRequest;

public class PleerTest {

	public static void main(String[] args) throws PleerException {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Naam: ");
			while (scanner.hasNext()) {
				PleerSession session = PleerSession.create();
				QueryBean query = session.request(new SearchRequest(scanner.nextLine()));
				TrackBean track = query.getTracks().entrySet().iterator().next().getValue();
				DownloadBean download_bean = session.request(new DownloadRequest(track.getId()));
				new DownloadThread(track, download_bean.getDownloadLink()).run();
				System.out.print("Naam: ");
			}
		}
	}

}