package kr.go.pohang.controller.product;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.pohang.dto.Product;
import kr.go.pohang.model.ProductDAO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/InsertProductPro.do")
public class InsertProductProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String savePath = "/product/img";	
		int uploadFileSizeLimit = 10 * 1024 * 1024;	
		String encType = "UTF-8";		
		ServletContext context = getServletContext();	
		String uploadFilePath = context.getRealPath(savePath);  
		System.out.println("지정된 업로드 디렉토리 : "+savePath);
		System.out.println("서버 상의 실제 업로드되는 디렉토리 : "+uploadFilePath);
		
		String pcode = "";
		String pname = "";
		String psize = "";
		String pinfo = "";
		int price = 0;
		String pic = "";
		ProductDAO dao = new ProductDAO();
		Product pro = new Product();
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());

			price = Integer.parseInt(multi.getParameter("price"));
			pic = multi.getFilesystemName("pic");
			if (pic == null) { 
				System.out.print("파일 업로드 실패~!");
			} else {
				pro.setPic("/img/"+pic);
			}
			pcode = multi.getParameter("pcode");
			pname = multi.getParameter("pname");
			psize = multi.getParameter("psize");
			pinfo = multi.getParameter("pinfo");
			
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}	
			pro.setPcode(pcode);
			pro.setPname(pname);
			pro.setPsize(psize);
			pro.setPinfo(pinfo);
			pro.setPrice(price);
		int cnt = dao.insertProduct(pro);	
		if(cnt==0){ //상품 등록 실패
			String msg = "상품을 등록하지 못했습니다.";
			request.setAttribute("msg", msg);

			RequestDispatcher view = request.getRequestDispatcher("product/insertProduct.jsp");
			view.forward(request, response);
		} else { 
			response.sendRedirect("ProductList.do");
		}
	}
}