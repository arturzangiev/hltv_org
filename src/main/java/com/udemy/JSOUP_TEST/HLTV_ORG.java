package com.udemy.JSOUP_TEST;

import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HLTV_ORG {

	public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36";
	
	public static void main(String[] args) throws Exception {
		
		final Document page = Jsoup.connect("https://www.hltv.org/results").userAgent(USER_AGENT).get();
		final PrintWriter out = new PrintWriter("results.txt");
		
		for (Element searchResult : page.select("body > div.bgPadding > div > div.colCon > div.contentCol > div > div.results-holder > div.results-all > div:nth-child(1)")) {
			final String title = searchResult.text();
			final String url = searchResult.attr("href");
			
			out.write(title + url);
		}
		out.close();
	}
}
