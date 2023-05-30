package kr.go.pohang.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

@WebServlet("/JSONTest5.do")
public class JSONTest5 {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        jsonTest5(request, response);
	}
	
	public void jsonTest5(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
