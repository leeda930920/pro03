package kr.go.pohang.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

@WebServlet("/JSONTest3.do")
public class JSONTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String msg = "";
    JSONObject json = new JSONObject();
    JSONArray json2 = new JSONArray();
	SampleDAO dao = new SampleDAO();
	ArrayList<Sample1> samList = new ArrayList<Sample1>();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
		
        jsonTest3(request, response);
	}
	
	public void jsonTest3() throws IOException{
		samList = dao.getSampleList();

		for(int i=0;i<samList.size();i++){
			JSONObject obj = new JSONObject();
			Sample1 sample = samList.get(i); 
			obj.put(i+"",sample);
			json2.put(obj);
		}
	}
	
	public void jsonTest3(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		ArrayList<Sample1> data = dao.getSampleList();

		PrintWriter out = response.getWriter();
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("data", data);
		
		net.sf.json.JSONObject json3 = new net.sf.json.JSONObject();
		//
		json3.putAll(map);
		out.println(json3.toString());	
	}
	
	@Test
	public void test() throws IOException {
		System.out.println("JSON Test3");
		jsonTest3();
		
		ArrayList<Sample1> sList = new ArrayList<Sample1>();
		for(int i=0;i<samList.size();i++){
			JSONObject obj = new JSONObject();
			obj = (JSONObject) json2.get(i);
			Sample1 s = (Sample1) obj.get(i+"");

			System.out.println("아이디 : "+s.getItem1());
			System.out.println("포인트 : "+s.getItem2());
			System.out.println("가입일 : "+s.getItem3());
			System.out.println("*************************");
			sList.add(s);
		}
	}
}
