package kr.go.pohang.controller.festival;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.pohang.model.FestivalDAO;

@WebServlet("/DelFestival.do")
public class DelFestivalCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		FestivalDAO ndao = new FestivalDAO();
		
		int cnt = ndao.deleteFestival(idx);
		if(cnt==0){ 
			String msg = "공지사항 글을 삭제하지 못했습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("GetFestival.do?idx="+idx);
		} else { 
			response.sendRedirect("FestivalList.do");
		}
	}
}
