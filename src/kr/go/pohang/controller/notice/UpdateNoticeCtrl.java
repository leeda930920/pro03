package kr.go.pohang.controller.notice;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.pohang.dto.Notice;
import kr.go.pohang.model.NoticeDAO;

/**
 * Servlet implementation class UpdateNoticeCtrl
 */
@WebServlet("/UpdateNotice.do")
public class UpdateNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		NoticeDAO ndao = new NoticeDAO();
		Notice noti = new Notice();
		
		noti = ndao.updateNotice(idx);
		

		String file1 = noti.getFile1().substring(5); 
		String filepath1 = noti.getFile1().substring(0,4);
		
		file1 = URLEncoder.encode(file1, "UTF-8");	
		
		request.setAttribute("file1", file1);
		request.setAttribute("filepath1", filepath1);
		request.setAttribute("noti", noti);
		

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/updateNotice.jsp");
		view.forward(request, response);
	}
}
