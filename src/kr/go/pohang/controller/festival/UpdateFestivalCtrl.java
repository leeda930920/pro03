package kr.go.pohang.controller.festival;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.pohang.dto.Festival;
import kr.go.pohang.model.FestivalDAO;

/**
 * Servlet implementation class UpdateNoticeCtrl
 */
@WebServlet("/UpdateFestival.do")
public class UpdateFestivalCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		FestivalDAO ndao = new FestivalDAO();
		Festival fes = new Festival();
		
		fes = ndao.updateFestival(idx);
		

		String file1 = fes.getFile1().substring(5); 
		String filepath1 = fes.getFile1().substring(0,4);
		
		file1 = URLEncoder.encode(file1, "UTF-8");	
		
		request.setAttribute("file1", file1);
		request.setAttribute("filepath1", filepath1);
		request.setAttribute("noti", fes);
		

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/festival/updateFestival.jsp");
		view.forward(request, response);
	}
}
