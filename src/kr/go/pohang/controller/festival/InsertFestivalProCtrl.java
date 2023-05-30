package kr.go.pohang.controller.festival;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import kr.go.pohang.dto.Festival;
import kr.go.pohang.model.FestivalDAO;

@WebServlet("/InsertFestivalPro.do")
public class InsertFestivalProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String savePath = "/WEB-INF/festival/img";	
		int uploadFileSizeLimit = 10 * 1024 * 1024;	
		String encType = "UTF-8";		
		ServletContext context = getServletContext();	
		String uploadFilePath = context.getRealPath(savePath); 
		System.out.println("지정된 업로드 디렉토리 : "+savePath);
		System.out.println("서버 상의 실제 업로드되는 디렉토리 : "+uploadFilePath);
		
		String title = "";
		String content = "";
		String author = "";
		String fileName = "";
		FestivalDAO ndao = new FestivalDAO();
		Festival fes = new Festival();
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			fileName = multi.getFilesystemName("file1"); 
			if (fileName == null) { 
				System.out.print("파일 업로드 실패~!");
			} else {
				fes.setFile1("img/"+fileName);
			}
			author = multi.getParameter("author");
			title = multi.getParameter("title");
			content = multi.getParameter("content");
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}	
		fes.setTitle(title);
		fes.setContent(content);
		fes.setAuthor(author);
		int cnt = ndao.insertFestival(fes);	
		if(cnt==0){ 
			String msg = "공지사항을 글이 등록되지 못했습니다.";
			request.setAttribute("msg", msg);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/festival/insertFestival.jsp");
			view.forward(request, response);
		} else { 
			response.sendRedirect("FestivalList.do");
		}
	}
}