package kr.go.pohang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.pohang.model.MySQL8;
import kr.go.pohang.model.UserDAO;
import kr.go.pohang.dto.Sns;
import kr.go.pohang.dto.User;

public class SnsDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	UserDAO udao = new UserDAO();
	
	public ArrayList<Sns> SnsListAll(){
		ArrayList<Sns> snsList = new ArrayList<Sns>();
		//Sns 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 snsList에 add를 한다.
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SNS_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				Sns sns = new Sns();
				sns.setIdx(rs.getInt("idx"));
				sns.setTitle(rs.getString("title"));
				sns.setContent(rs.getString("content"));
				sns.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				sns.setName(user.getName());
				sns.setFile1(rs.getString("file1"));
				sns.setResdate(rs.getString("resdate"));
				sns.setReadcnt(rs.getInt("readcnt"));
				snsList.add(sns);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return snsList;
	}
	
	public Sns getSns(int idx){
		updateReadCount(idx);
		Sns sns = new Sns();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 sns에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SNS_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				sns.setIdx(rs.getInt("idx"));
				sns.setTitle(rs.getString("title"));
				sns.setContent(rs.getString("content"));
				sns.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				sns.setName(user.getName());
				sns.setFile1(rs.getString("file1"));
				sns.setResdate(rs.getString("resdate"));
				sns.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return sns;
	}
	
	public void updateReadCount(int idx){
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SNS_READCOUNT_UPDATE);
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
	
	public int insertSns(Sns sns){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.INSERT_SNS);
			pstmt.setString(1, sns.getTitle());
			pstmt.setString(2, sns.getContent());
			pstmt.setString(3, sns.getAuthor());
			pstmt.setString(4, "data/"+sns.getFile1());
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
	
	public Sns updateSns(int idx){
		Sns sns = new Sns();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 sns에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SNS_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				sns.setIdx(rs.getInt("idx"));
				sns.setTitle(rs.getString("title"));
				sns.setContent(rs.getString("content"));
				sns.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				sns.setName(user.getName());
				sns.setFile1(rs.getString("file1"));
				sns.setResdate(rs.getString("resdate"));
				sns.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return sns;
	}

	public int updateSnsPro(Sns sns) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			if(sns.getFile1()==null) {
				pstmt = con.prepareStatement(MySQL8.UPDATE_SNS2);
				pstmt.setString(1, sns.getTitle());
				pstmt.setString(2, sns.getContent());
				pstmt.setInt(3, sns.getIdx());
			} else {
				pstmt = con.prepareStatement(MySQL8.UPDATE_SNS);
				pstmt.setString(1, sns.getTitle());
				pstmt.setString(2, sns.getContent());
				pstmt.setString(3, sns.getFile1());
				pstmt.setInt(4, sns.getIdx());
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

	public int deleteSns(int idx) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_SNS);
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
