package kr.go.pohang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.pohang.model.MySQL8;
import kr.go.pohang.model.UserDAO;
import kr.go.pohang.dto.Festival;
import kr.go.pohang.dto.User;

public class FestivalDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	UserDAO udao = new UserDAO();
	
	public ArrayList<Festival> FestivalListAll(){
		ArrayList<Festival> fesList = new ArrayList<Festival>();
		//Festival 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 fesList에 add를 한다.
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.FESTIVAL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				Festival fes = new Festival();
				fes.setIdx(rs.getInt("idx"));
				fes.setTitle(rs.getString("title"));
				fes.setContent(rs.getString("content"));
				fes.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				fes.setName(user.getName());
				fes.setFile1(rs.getString("file1"));
				fes.setResdate(rs.getString("resdate"));
				fes.setReadcnt(rs.getInt("readcnt"));
				fesList.add(fes);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return fesList;
	}
	
	public Festival getFestival(int idx){
		updateReadCount(idx);
		Festival fes = new Festival();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 fes에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.FESTIVAL_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				fes.setIdx(rs.getInt("idx"));
				fes.setTitle(rs.getString("title"));
				fes.setContent(rs.getString("content"));
				fes.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				fes.setName(user.getName());
				fes.setFile1(rs.getString("file1"));
				fes.setResdate(rs.getString("resdate"));
				fes.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return fes;
	}
	
	public void updateReadCount(int idx){
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.FESTIVAL_READCOUNT_UPDATE);
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
	
	public int insertFestival(Festival fes){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.INSERT_FESTIVAL);
			pstmt.setString(1, fes.getTitle());
			pstmt.setString(2, fes.getContent());
			pstmt.setString(3, fes.getAuthor());
			pstmt.setString(4, "data/"+fes.getFile1());
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
	
	public Festival updateFestival(int idx){
		Festival fes = new Festival();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 fes에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.FESTIVAL_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				fes.setIdx(rs.getInt("idx"));
				fes.setTitle(rs.getString("title"));
				fes.setContent(rs.getString("content"));
				fes.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				fes.setName(user.getName());
				fes.setFile1(rs.getString("file1"));
				fes.setResdate(rs.getString("resdate"));
				fes.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return fes;
	}

	public int updateFestivalPro(Festival fes) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			if(fes.getFile1()==null) {
				pstmt = con.prepareStatement(MySQL8.UPDATE_FESTIVAL2);
				pstmt.setString(1, fes.getTitle());
				pstmt.setString(2, fes.getContent());
				pstmt.setInt(3, fes.getIdx());
			} else {
				pstmt = con.prepareStatement(MySQL8.UPDATE_FESTIVAL);
				pstmt.setString(1, fes.getTitle());
				pstmt.setString(2, fes.getContent());
				pstmt.setString(3, fes.getFile1());
				pstmt.setInt(4, fes.getIdx());
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

	public int deleteFestival(int idx) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_FESTIVAL);
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
