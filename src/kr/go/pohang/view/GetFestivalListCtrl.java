package kr.go.pohang.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.pohang.dto.Festival;
import kr.go.pohang.model.FestivalDAO;

@WebServlet("/FestivalList.do")
public class GetFestivalListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FestivalDAO ndao = new FestivalDAO();
		ArrayList<Festival> fesList = new ArrayList<Festival>();
		fesList = ndao.FestivalListAll();
		request.setAttribute("fesList", fesList);
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/festival/festivalList.jsp");
		view.forward(request, response);
	
	}
}
