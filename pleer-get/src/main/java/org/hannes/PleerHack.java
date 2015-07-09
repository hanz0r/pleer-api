//package org.hannes;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//
//import com.google.gson.Gson;
//
//public class PleerHack {
//
//	public static void main(String[] args) throws Exception {
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		HttpPost httpPost = new HttpPost("http://pleer.com/site_api/files/get_url");
//		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
//		nvps.add(new BasicNameValuePair("id", "9899444bhP3"));
//		nvps.add(new BasicNameValuePair("action", "play"));
//		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
//		CloseableHttpResponse response = httpclient.execute(httpPost);
//		
//		
//		Gson gson = new Gson();
//		Bean bean = gson.fromJson(create(response.getEntity()), Bean.class);
//		System.out.println(bean.track_link);
//	}
//
//	private static String create(HttpEntity entity) throws UnsupportedOperationException, IOException {
//		StringBuilder builder = new StringBuilder();
//	    try (Scanner scanner = new Scanner(entity.getContent())) {
//	    	while (scanner.hasNext()) {
//	    		builder.append(scanner.nextLine());
//	    	}
//	    }
//	    return builder.toString();
//	}
//
//}