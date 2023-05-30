package kr.go.pohang.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.pohang.dto.*;
import kr.go.pohang.model.*;

import java.util.ArrayList;


public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String projectName = "포항 문화 관광";
		
		//홈 디렉토리 잡기
		ServletContext application = request.getServletContext();
		String realPath = request.getSession().getServletContext().getRealPath("/");
		application.setAttribute("realPath", realPath);
		
		NoticeDAO ndao = new NoticeDAO();
		ArrayList<Notice> notiList = new ArrayList<Notice>();
		notiList = ndao.noticeListAll();
		request.setAttribute("notiList", notiList);
		
		
		//메인 페이지 포워딩
		request.setAttribute("projectName", projectName);
		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
		view.forward(request, response);
	}
}
