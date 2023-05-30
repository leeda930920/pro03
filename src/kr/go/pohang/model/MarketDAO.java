package kr.go.pohang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.pohang.model.MySQL8;
import kr.go.pohang.model.UserDAO;
import kr.go.pohang.dto.Market;
import kr.go.pohang.dto.User;

public class MarketDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	UserDAO udao = new UserDAO();
	
	public ArrayList<Market> MarketListAll(){
		ArrayList<Market> marList = new ArrayList<Market>();
		//Market 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 marList에 add를 한다.
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.MARKET_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				Market mar = new Market();
				mar.setIdx(rs.getInt("idx"));
				mar.setTitle(rs.getString("title"));
				mar.setContent(rs.getString("content"));
				mar.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				mar.setName(user.getName());
				mar.setFile1(rs.getString("file1"));
				mar.setResdate(rs.getString("resdate"));
				mar.setReadcnt(rs.getInt("readcnt"));
				marList.add(mar);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return marList;
	}
	
	public Market getMarket(int idx){
		updateReadCount(idx);
		Market mar = new Market();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 mar에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.MARKET_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				mar.setIdx(rs.getInt("idx"));
				mar.setTitle(rs.getString("title"));
				mar.setContent(rs.getString("content"));
				mar.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				mar.setName(user.getName());
				mar.setFile1(rs.getString("file1"));
				mar.setResdate(rs.getString("resdate"));
				mar.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return mar;
	}
	
	public void updateReadCount(int idx){
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.MARKET_READCOUNT_UPDATE);
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
	
	public int insertMarket(Market mar){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.INSERT_MARKET);
			pstmt.setString(1, mar.getTitle());
			pstmt.setString(2, mar.getContent());
			pstmt.setString(3, mar.getAuthor());
			pstmt.setString(4, "data/"+mar.getFile1());
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
	
	public Market updateMarket(int idx){
		Market mar = new Market();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 mar에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.MARKET_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				mar.setIdx(rs.getInt("idx"));
				mar.setTitle(rs.getString("title"));
				mar.setContent(rs.getString("content"));
				mar.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				mar.setName(user.getName());
				mar.setFile1(rs.getString("file1"));
				mar.setResdate(rs.getString("resdate"));
				mar.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return mar;
	}

	public int updateMarketPro(Market mar) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			if(mar.getFile1()==null) {
				pstmt = con.prepareStatement(MySQL8.UPDATE_MARKET2);
				pstmt.setString(1, mar.getTitle());
				pstmt.setString(2, mar.getContent());
				pstmt.setInt(3, mar.getIdx());
			} else {
				pstmt = con.prepareStatement(MySQL8.UPDATE_MARKET);
				pstmt.setString(1, mar.getTitle());
				pstmt.setString(2, mar.getContent());
				pstmt.setString(3, mar.getFile1());
				pstmt.setInt(4, mar.getIdx());
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

	public int deleteMarket(int idx) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_MARKET);
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
