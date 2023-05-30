package kr.go.pohang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.pohang.model.MySQL8;
import kr.go.pohang.model.UserDAO;
import kr.go.pohang.dto.Tourist;
import kr.go.pohang.dto.User;

public class TouristDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	UserDAO udao = new UserDAO();
	
	public ArrayList<Tourist> TouristListAll(){
		ArrayList<Tourist> touList = new ArrayList<Tourist>();
		//Tourist 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 touList에 add를 한다.
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.TOURIST_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				Tourist tou = new Tourist();
				tou.setIdx(rs.getInt("idx"));
				tou.setTitle(rs.getString("title"));
				tou.setContent(rs.getString("content"));
				tou.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				tou.setName(user.getName());
				tou.setFile1(rs.getString("file1"));
				tou.setResdate(rs.getString("resdate"));
				tou.setReadcnt(rs.getInt("readcnt"));
				touList.add(tou);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return touList;
	}
	
	public Tourist getTourist(int idx){
		updateReadCount(idx);
		Tourist tou = new Tourist();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 tou에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.TOURIST_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				tou.setIdx(rs.getInt("idx"));
				tou.setTitle(rs.getString("title"));
				tou.setContent(rs.getString("content"));
				tou.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				tou.setName(user.getName());
				tou.setFile1(rs.getString("file1"));
				tou.setResdate(rs.getString("resdate"));
				tou.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return tou;
	}
	
	public void updateReadCount(int idx){
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.TOURIST_READCOUNT_UPDATE);
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
	
	public int insertTourist(Tourist tou){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.INSERT_TOURIST);
			pstmt.setString(1, tou.getTitle());
			pstmt.setString(2, tou.getContent());
			pstmt.setString(3, tou.getAuthor());
			pstmt.setString(4, "data/"+tou.getFile1());
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
	
	public Tourist updateTourist(int idx){
		Tourist tou = new Tourist();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 tou에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.TOURIST_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				tou.setIdx(rs.getInt("idx"));
				tou.setTitle(rs.getString("title"));
				tou.setContent(rs.getString("content"));
				tou.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				tou.setName(user.getName());
				tou.setFile1(rs.getString("file1"));
				tou.setResdate(rs.getString("resdate"));
				tou.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return tou;
	}

	public int updateTouristPro(Tourist tou) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			if(tou.getFile1()==null) {
				pstmt = con.prepareStatement(MySQL8.UPDATE_TOURIST2);
				pstmt.setString(1, tou.getTitle());
				pstmt.setString(2, tou.getContent());
				pstmt.setInt(3, tou.getIdx());
			} else {
				pstmt = con.prepareStatement(MySQL8.UPDATE_TOURIST);
				pstmt.setString(1, tou.getTitle());
				pstmt.setString(2, tou.getContent());
				pstmt.setString(3, tou.getFile1());
				pstmt.setInt(4, tou.getIdx());
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

	public int deleteTourist(int idx) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_TOURIST);
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
