package kr.go.pohang.controller.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.pohang.model.QnaDAO;
import kr.go.pohang.vo.QnaVO;

@WebServlet("/QnaList.do")
public class GetQnaListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		QnaDAO dao = new QnaDAO();
		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		qnaList = dao.getQnaList();
		request.setAttribute("qnaList", qnaList);
		
		//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
		RequestDispatcher view = request.getRequestDispatcher("/qna/qnaList.jsp");
		view.forward(request, response);
	}
}
