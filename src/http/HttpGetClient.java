package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetClient {

	public static void main(String[] args) {
		
		// 자바 기본 코드로 HTTP 요청을 만들어 보자!
		
		// HTTP 통신을 하기위한 준비물
		// 서버 주소 (경로준비)
		String urlString = "https://jsonplaceholder.typicode.com/todos/5";
//		String urlString = "https://www.google.com/search?q=%EC%9E%90%EB%B0%94&oq=%EC%9E%90%EB%B0%94&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIGCAEQRRg7MgYIAhBFGDsyBggDEEUYOzIGCAQQIxgnMgwIBRAjGCcYgAQYigUyDAgGEAAYQxiABBiKBTINCAcQABiDARixAxiABDINCAgQABiDARixAxiABDINCAkQABiDARixAxiABNIBCTU1MzlqMGoxNagCALACAA&sourceid=chrome&ie=UTF-8";
		
		// 1. URL 클래스를 만들어 준다.
		// 2. Connection 객체를 만들어 준다. (URL --> 멤버로 Connection 객체를 뽑을수 있다.)
		try {
			URL url = new URL(urlString);
			// 이때 url.openConnection()을 연결 요청 진행
			HttpURLConnection conn = (HttpURLConnection)url.openConnection(); // 다운캐스팅

			// 추가 설정을 할 수 있음
			// METHOD 방식 설정(약속) --- GET 요청은 해당 서버의 자원 요청
			conn.setRequestMethod("GET");
			
			// HTTP 응답 메세지에서 데이터를 추출할 수 있다.
			int responceCode = conn.getResponseCode();
			System.out.println("HTTP CODE : " +responceCode);
			
			
		BufferedReader brIn =
				new BufferedReader( new InputStreamReader(	conn.getInputStream() ) );
		
		String inputLine;
		StringBuffer resStringBuffer = new StringBuffer();
		
		while((inputLine = brIn.readLine())!= null) {
			resStringBuffer.append(inputLine);
		}
		brIn.close();
		
		// System.out.println(resStringBuffer.toString());
		String[] strHtmls = resStringBuffer.toString().split("\\s");
		System.out.println("index count : " + strHtmls.length);
		
		for(String word : strHtmls) {
			System.out.println(word);
		}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	} // end of main

} // end of class
