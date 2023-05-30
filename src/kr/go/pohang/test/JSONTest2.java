package kr.go.pohang.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;
import org.junit.Test;

@WebServlet("/JSONTest2.do")
public class JSONTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String msg = "";
    JSONObject json = new JSONObject();
	SampleDAO dao = new SampleDAO();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
		
        jsonTest2(request, response);
	}
	
	public void jsonTest2(String item1) throws IOException{
		Sample1 result = dao.getSample(item1);
				
		json.put("name", result.getItem1());
		json.put("point", result.getItem2());
		json.put("resdate", result.getItem3());
	}
	
	public void jsonTest2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name = request.getParameter("item1");
		
		Sample1 result = dao.getSample(name);
				
		json.put("name", result.getItem1());
		json.put("point", result.getItem2());
		json.put("resdate", result.getItem3());
		PrintWriter out = response.getWriter();
		out.println(json.toString());	
	}
	
	@Test
	public void test() throws IOException {
		System.out.println("JSON Test2");
		jsonTest2("kimkitae");
		System.out.println("아이디 : "+json.get("name"));
		System.out.println("포인트 : "+json.get("point"));
		System.out.println("가입일 : "+json.get("resdate"));
	}

}
