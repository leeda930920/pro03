package kr.go.pohang.view;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.pohang.dto.Festival;
import kr.go.pohang.dto.User;
import kr.go.pohang.model.FestivalDAO;
import kr.go.pohang.model.UserDAO;

@WebServlet("/GetFestival.do")
public class GetFestivalCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		FestivalDAO ndao = new FestivalDAO();
		Festival fes = new Festival();
		fes = ndao.getFestival(idx);
		String file1 = "";
		String filepath1 = "";
		
		if(fes.getFile1()!=null){
			file1 = fes.getFile1().substring(4); 
			filepath1 = fes.getFile1().substring(0,3);
			file1 = URLEncoder.encode(file1, "UTF-8");	
		}
		request.setAttribute("file1", file1);
		request.setAttribute("filepath1", filepath1);
		request.setAttribute("fes", fes);

		HttpSession ses = request.getSession();
		String id = (String) ses.getAttribute("sid");
		
		UserDAO udao = new UserDAO();
		User user = new User(); 
		try {
			user = udao.myInfo(id);
		} catch (InvalidKeyException | NoSuchPaddingException
				| NoSuchAlgorithmException | InvalidKeySpecException
				| InvalidAlgorithmParameterException | BadPaddingException
				| IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user", user);
		
		//디스패치로 view를 생성하여 getNotice.jsp로 요청 받은 noti를 포워드
		RequestDispatcher view2 = request.getRequestDispatcher("/WEB-INF/festival/getFestival.jsp");
		view2.forward(request, response);

		
	}
}
