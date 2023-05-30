package kr.go.pohang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import kr.go.pohang.model.MySQL8;


import kr.go.pohang.dto.Product;

public class ProductDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	//상품 상세 보기
	public Product getProduct(String pcode){
		Product pro = new Product();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.PRODUCT_SELECT);
			pstmt.setString(1, pcode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				pro.setPcode(rs.getString("pcode"));
				pro.setPname(rs.getString("pname"));
				pro.setPsize(rs.getString("psize"));
				pro.setPrice(rs.getInt("price"));
				pro.setPinfo(rs.getString("pinfo"));
				pro.setPic(rs.getString("pic"));

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return pro;
	}
	
	//전체 상품 목록 불러오기
	public ArrayList<Product> getProductList(){
		ArrayList<Product> proList = new ArrayList<Product>();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.PRODUCT_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Product pro = new Product();
				pro.setPcode(rs.getString("pcode"));
				pro.setPname(rs.getString("pname"));
				pro.setPsize(rs.getString("psize"));
				pro.setPrice(rs.getInt("price"));
				pro.setPinfo(rs.getString("pinfo"));
				pro.setPic(rs.getString("pic"));
				proList.add(pro);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(rs, pstmt, con);
		}
		return proList;
	}

	//상품 등록 처리
	public int insertProduct(Product pro) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.INSERT_PRODUCT);
			pstmt.setString(1, pro.getPcode());
			pstmt.setString(2, pro.getPname());
			pstmt.setString(3, pro.getPsize());
			pstmt.setInt(4, pro.getPrice());
			pstmt.setString(5, pro.getPinfo());
			pstmt.setString(6, pro.getPic());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(pstmt, con);
		return cnt;
	}


	public int updateProduct(Product pro) {
		int cnt =0 ;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.UPDATE_PRODUCT2);
			pstmt.setString(1, pro.getPname());
			pstmt.setString(2, pro.getPsize());
			pstmt.setInt(3, pro.getPrice());
			pstmt.setString(4, pro.getPinfo());
			pstmt.setString(5, pro.getPic());
			pstmt.setString(6, pro.getPcode());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(pstmt, con);
		return cnt;
	}

	public int deleteProduct(String pcode) {
		int cnt =0 ;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_PRODUCT);
			pstmt.setString(1, pcode);
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(pstmt, con);
		return cnt;
	}
	
	public int salesProduct(String pcode, int amount){
		int cnt =0 ;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SALES_PRODUCT);
			pstmt.setInt(1, amount);
			pstmt.setString(2, pcode);
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(pstmt, con);
		return cnt;
	}




}