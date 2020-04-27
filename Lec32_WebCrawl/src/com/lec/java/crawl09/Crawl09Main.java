package com.lec.java.crawl09;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//연습
//네이버 '검색어' 
//블로그 
//- post title
//- post url
//- blog title

//페이징 구현!

public class Crawl09Main {

	public static void main(String[] args) throws IOException {
		System.out.println("페이징 연습");

		for(int i=1 ;i<=10;i++) {
			crawlNaverBlog("파이썬", i);
		}
		
		System.out.println("\n프로그램 종료");
	}
	public static void crawlNaverBlog(String search,int start) throws IOException {
		
		if(search == null || search.trim().length()==0||start<1) return;
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;
		
		url = String.format("https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%s&sm=tab_pge&srchby=all&st=sim&where=post&start=%d", URLEncoder.encode(search,"utf-8"),start);
		
		doc = Jsoup.connect(url).execute().parse();
		elements =doc.select(".blog #elThumbnailResultArea li dl");
		System.out.println(elements.size());
		
		for(Element e : elements) {
			String postTitle = e.selectFirst("a").text().trim();
			String blogTitle = e.selectFirst(".inline .url").text().trim();
			String postUrl = e.selectFirst("a").attr("href").trim();
			
			System.out.println(postTitle+" / "+blogTitle+" / "+postUrl);
		}
		//System.out.println(url);
	}

}
