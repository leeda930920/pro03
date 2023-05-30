package kr.go.pohang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.pohang.model.MySQL8;
import kr.go.pohang.model.UserDAO;
import kr.go.pohang.dto.Leisure;
import kr.go.pohang.dto.User;

public class LeisureDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	UserDAO udao = new UserDAO();
	
	public ArrayList<Leisure> LeisureListAll(){
		ArrayList<Leisure> leiList = new ArrayList<Leisure>();
		//Leisure 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 leiList에 add를 한다.
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.LEISURE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				Leisure lei = new Leisure();
				lei.setIdx(rs.getInt("idx"));
				lei.setTitle(rs.getString("title"));
				lei.setContent(rs.getString("content"));
				lei.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				lei.setName(user.getName());
				lei.setFile1(rs.getString("file1"));
				lei.setResdate(rs.getString("resdate"));
				lei.setReadcnt(rs.getInt("readcnt"));
				leiList.add(lei);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return leiList;
	}
	
	public Leisure getLeisure(int idx){
		updateReadCount(idx);
		Leisure lei = new Leisure();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 lei에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.LEISURE_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				lei.setIdx(rs.getInt("idx"));
				lei.setTitle(rs.getString("title"));
				lei.setContent(rs.getString("content"));
				lei.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				lei.setName(user.getName());
				lei.setFile1(rs.getString("file1"));
				lei.setResdate(rs.getString("resdate"));
				lei.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return lei;
	}
	
	public void updateReadCount(int idx){
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.LEISURE_READCOUNT_UPDATE);
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
	
	public int insertLeisure(Leisure lei){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.INSERT_LEISURE);
			pstmt.setString(1, lei.getTitle());
			pstmt.setString(2, lei.getContent());
			pstmt.setString(3, lei.getAuthor());
			pstmt.setString(4, "data/"+lei.getFile1());
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
	
	public Leisure updateLeisure(int idx){
		Leisure lei = new Leisure();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 lei에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.LEISURE_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				lei.setIdx(rs.getInt("idx"));
				lei.setTitle(rs.getString("title"));
				lei.setContent(rs.getString("content"));
				lei.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				lei.setName(user.getName());
				lei.setFile1(rs.getString("file1"));
				lei.setResdate(rs.getString("resdate"));
				lei.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return lei;
	}

	public int updateLeisurePro(Leisure lei) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			if(lei.getFile1()==null) {
				pstmt = con.prepareStatement(MySQL8.UPDATE_LEISURE2);
				pstmt.setString(1, lei.getTitle());
				pstmt.setString(2, lei.getContent());
				pstmt.setInt(3, lei.getIdx());
			} else {
				pstmt = con.prepareStatement(MySQL8.UPDATE_LEISURE);
				pstmt.setString(1, lei.getTitle());
				pstmt.setString(2, lei.getContent());
				pstmt.setString(3, lei.getFile1());
				pstmt.setInt(4, lei.getIdx());
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

	public int deleteLeisure(int idx) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_LEISURE);
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
