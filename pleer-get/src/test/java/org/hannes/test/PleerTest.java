package org.hannes.test;

import org.hannes.pleer.DownloadRequest;
import org.hannes.pleer.Pleer;
import org.hannes.pleer.PleerException;
import org.hannes.pleer.beans.DownloadBean;

public class PleerTest {

	public static void main(String[] args) throws PleerException {
		Pleer pleer = new Pleer();
		DownloadBean bean = pleer.request(new DownloadRequest("9899444bhP3"));
		System.out.println(bean.getDownloadLink());
	}

}