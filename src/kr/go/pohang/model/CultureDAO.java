package kr.go.pohang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.pohang.model.MySQL8;
import kr.go.pohang.model.UserDAO;
import kr.go.pohang.dto.Culture;
import kr.go.pohang.dto.User;

public class CultureDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	UserDAO udao = new UserDAO();
	
	public ArrayList<Culture> CultureListAll(){
		ArrayList<Culture> culList = new ArrayList<Culture>();
		//Culture 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 culList에 add를 한다.
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.CULTURE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				Culture cul = new Culture();
				cul.setIdx(rs.getInt("idx"));
				cul.setTitle(rs.getString("title"));
				cul.setContent(rs.getString("content"));
				cul.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				cul.setName(user.getName());
				cul.setFile1(rs.getString("file1"));
				cul.setResdate(rs.getString("resdate"));
				cul.setReadcnt(rs.getInt("readcnt"));
				culList.add(cul);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return culList;
	}
	
	public Culture getCulture(int idx){
		updateReadCount(idx);
		Culture cul = new Culture();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 cul에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.CULTURE_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cul.setIdx(rs.getInt("idx"));
				cul.setTitle(rs.getString("title"));
				cul.setContent(rs.getString("content"));
				cul.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				cul.setName(user.getName());
				cul.setFile1(rs.getString("file1"));
				cul.setResdate(rs.getString("resdate"));
				cul.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return cul;
	}
	
	public void updateReadCount(int idx){
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.CULTURE_READCOUNT_UPDATE);
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
	
	public int insertCulture(Culture cul){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.INSERT_CULTURE);
			pstmt.setString(1, cul.getTitle());
			pstmt.setString(2, cul.getContent());
			pstmt.setString(3, cul.getAuthor());
			pstmt.setString(4, "data/"+cul.getFile1());
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
	
	public Culture updateCulture(int idx){
		Culture cul = new Culture();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 cul에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.CULTURE_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cul.setIdx(rs.getInt("idx"));
				cul.setTitle(rs.getString("title"));
				cul.setContent(rs.getString("content"));
				cul.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				cul.setName(user.getName());
				cul.setFile1(rs.getString("file1"));
				cul.setResdate(rs.getString("resdate"));
				cul.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return cul;
	}

	public int updateCulturePro(Culture cul) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			if(cul.getFile1()==null) {
				pstmt = con.prepareStatement(MySQL8.UPDATE_CULTURE2);
				pstmt.setString(1, cul.getTitle());
				pstmt.setString(2, cul.getContent());
				pstmt.setInt(3, cul.getIdx());
			} else {
				pstmt = con.prepareStatement(MySQL8.UPDATE_CULTURE);
				pstmt.setString(1, cul.getTitle());
				pstmt.setString(2, cul.getContent());
				pstmt.setString(3, cul.getFile1());
				pstmt.setInt(4, cul.getIdx());
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

	public int deleteCulture(int idx) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_CULTURE);
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
