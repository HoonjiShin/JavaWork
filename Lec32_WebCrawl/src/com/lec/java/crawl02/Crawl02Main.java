package com.lec.java.crawl02;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl02Main {

	public static void main(String[] args)throws IOException {
		String url;
		Response response;
		Document doc = null;
		Element element;
		Elements elements;
		int count = 1;
		url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
		response = Jsoup.connect(url).execute();

		doc = response.parse();
	elements = doc.select("div");
		
		Elements hotkeyword = doc.select(".title .tit3 a");
		
		for(Element e : hotkeyword) {
			
			element = e.selectFirst("a");
			System.out.println((count++)+"위   "+e.text().trim());
			
		}
	}
}