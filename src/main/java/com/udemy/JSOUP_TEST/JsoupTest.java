package com.udemy.JSOUP_TEST;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;


public class JsoupTest {

	public static void main(String[] args) throws IOException {

		final Document doc = Jsoup.connect("http://en.wikipedia.org/").get(); 
		
		final Elements newsHeadLines = doc.select("#mp-itn b a");
		
		for (Element headline : newsHeadLines) {
			System.out.println(headline.text());
		}
		
		System.out.println("\n\n---------------------------------------------------------------------------------------------\n\n");
	
		System.out.println(doc.outerHtml());
	}

}
