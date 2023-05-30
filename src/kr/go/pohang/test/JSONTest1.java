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

@WebServlet("/JSONTest1.do")
public class JSONTest1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    String msg = "";
    JSONObject json = new JSONObject();
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        jsonTest1(request, response);
	}
	
	public void jsonTest1() throws IOException{
		String result = "자바앱 텍스트 데이터";
		json.put("result", result);
	}
	
	public void jsonTest1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String result = "자바 웹앱 텍스트 데이터";
		json.put("result", result);
		PrintWriter out = response.getWriter();
		out.println(json);		
	}
	
	@Test
	public void test() throws IOException {
		System.out.println("JSON Test1");
		jsonTest1();
		System.out.println(json.get("result"));
	}
}
