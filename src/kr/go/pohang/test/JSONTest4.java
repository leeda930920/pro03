package kr.go.pohang.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.junit.Test;

@WebServlet("/JSONTest4.do")
public class JSONTest4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JSONObject json = new JSONObject();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
		appTest(request, response);
	}
	
	public void appTest(){
		String result = "자바 애플리케이션 테스트";
		json.put("result", result);
	}

	public void appTest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String result = "자바 웹앱 텍스트 데이터";
		json.put("result", result);
		out.println(json);		
	}
	
	@Test
	public void test1(){
		appTest();
		System.out.println(json.get("result"));
	}
}
