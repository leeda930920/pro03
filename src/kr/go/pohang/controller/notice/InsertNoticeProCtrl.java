package kr.go.pohang.controller.notice;

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
import kr.go.pohang.dto.Notice;
import kr.go.pohang.model.NoticeDAO;

@WebServlet("/InsertNoticePro.do")
public class InsertNoticeProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String savePath = "/data";	
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
		NoticeDAO ndao = new NoticeDAO();
		Notice noti = new Notice();
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			fileName = multi.getFilesystemName("file1"); 
			if (fileName == null) { 
				System.out.print("파일 업로드 실패~!");
			} else {
				noti.setFile1("data/"+fileName);
			}
			author = multi.getParameter("author");
			title = multi.getParameter("title");
			content = multi.getParameter("content");
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}	
		noti.setTitle(title);
		noti.setContent(content);
		noti.setAuthor(author);
		int cnt = ndao.insertNotice(noti);	
		if(cnt==0){ 
			String msg = "공지사항을 글이 등록되지 못했습니다.";
			request.setAttribute("msg", msg);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/insertNotice.jsp");
			view.forward(request, response);
		} else { 
			response.sendRedirect("NoticeList.do");
		}
	}
}