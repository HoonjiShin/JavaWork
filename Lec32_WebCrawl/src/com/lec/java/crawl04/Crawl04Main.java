package com.lec.java.crawl04;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl04Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 연관 검색어");

		String url;
		Document doc; 
		Response response;
		Elements elements;
		Element element;
		
		String searchKeyword;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요");
		searchKeyword = sc.nextLine();
		sc.close();
		
		String encoded = URLEncoder.encode(searchKeyword,"utf-8"); //네이버 검색페이지는 UTF-8로 url encoding 함.
		url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query="+encoded;
		System.out.println(url);
		
		
		doc = Jsoup.connect(url).execute().parse();
		String outerHtml = doc.outerHtml();
		
		Elements relatedwords = doc.select("._related_keyword_list ._related_keyword_ul li");
		
		System.out.println(relatedwords.size());
		
		for(Element e : relatedwords) {
			element = e.selectFirst("a");
			System.out.println(element.text()); //element의 text() -> text들을 묶어서 하나로 리턴
			System.out.println(element.attr("href"));
		}
		
		System.out.println("\n프로그램 종료");

	}

}
