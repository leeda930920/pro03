package kr.go.pohang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.pohang.model.MySQL8;
import kr.go.pohang.model.UserDAO;
import kr.go.pohang.dto.Food;
import kr.go.pohang.dto.User;

public class FoodDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	UserDAO udao = new UserDAO();
	
	public ArrayList<Food> FoodListAll(){
		ArrayList<Food> fooList = new ArrayList<Food>();
		//Food 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 fooList에 add를 한다.
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.FOOD_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				Food foo = new Food();
				foo.setIdx(rs.getInt("idx"));
				foo.setTitle(rs.getString("title"));
				foo.setContent(rs.getString("content"));
				foo.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				foo.setName(user.getName());
				foo.setFile1(rs.getString("file1"));
				foo.setResdate(rs.getString("resdate"));
				foo.setReadcnt(rs.getInt("readcnt"));
				fooList.add(foo);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return fooList;
	}
	
	public Food getFood(int idx){
		updateReadCount(idx);
		Food foo = new Food();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 foo에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.FOOD_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				foo.setIdx(rs.getInt("idx"));
				foo.setTitle(rs.getString("title"));
				foo.setContent(rs.getString("content"));
				foo.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				foo.setName(user.getName());
				foo.setFile1(rs.getString("file1"));
				foo.setResdate(rs.getString("resdate"));
				foo.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return foo;
	}
	
	public void updateReadCount(int idx){
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.FOOD_READCOUNT_UPDATE);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(pstmt, con);
	}
	
	public int insertFood(Food foo){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.INSERT_FOOD);
			pstmt.setString(1, foo.getTitle());
			pstmt.setString(2, foo.getContent());
			pstmt.setString(3, foo.getAuthor());
			pstmt.setString(4, "data/"+foo.getFile1());
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
	
	public Food updateFood(int idx){
		Food foo = new Food();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 foo에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.FOOD_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				foo.setIdx(rs.getInt("idx"));
				foo.setTitle(rs.getString("title"));
				foo.setContent(rs.getString("content"));
				foo.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				foo.setName(user.getName());
				foo.setFile1(rs.getString("file1"));
				foo.setResdate(rs.getString("resdate"));
				foo.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return foo;
	}

	public int updateFoodPro(Food foo) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			if(foo.getFile1()==null) {
				pstmt = con.prepareStatement(MySQL8.UPDATE_FOOD2);
				pstmt.setString(1, foo.getTitle());
				pstmt.setString(2, foo.getContent());
				pstmt.setInt(3, foo.getIdx());
			} else {
				pstmt = con.prepareStatement(MySQL8.UPDATE_FOOD);
				pstmt.setString(1, foo.getTitle());
				pstmt.setString(2, foo.getContent());
				pstmt.setString(3, foo.getFile1());
				pstmt.setInt(4, foo.getIdx());
			}
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(pstmt, con);
		return cnt;
	}

	public int deleteFood(int idx) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_FOOD);
			pstmt.setInt(1, idx);

			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		return cnt;
	}
}
