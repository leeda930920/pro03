package kr.go.pohang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.pohang.model.MySQL8;
import kr.go.pohang.model.UserDAO;
import kr.go.pohang.dto.Hotel;
import kr.go.pohang.dto.User;

public class HotelDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	UserDAO udao = new UserDAO();
	
	public ArrayList<Hotel> HotelListAll(){
		ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		//Hotel 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 hotelList에 add를 한다.
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.HOTEL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				Hotel hotel = new Hotel();
				hotel.setIdx(rs.getInt("idx"));
				hotel.setTitle(rs.getString("title"));
				hotel.setContent(rs.getString("content"));
				hotel.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				hotel.setName(user.getName());
				hotel.setFile1(rs.getString("file1"));
				hotel.setResdate(rs.getString("resdate"));
				hotel.setReadcnt(rs.getInt("readcnt"));
				hotelList.add(hotel);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return hotelList;
	}
	
	public Hotel getHotel(int idx){
		updateReadCount(idx);
		Hotel hotel = new Hotel();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 hotel에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.HOTEL_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				hotel.setIdx(rs.getInt("idx"));
				hotel.setTitle(rs.getString("title"));
				hotel.setContent(rs.getString("content"));
				hotel.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				hotel.setName(user.getName());
				hotel.setFile1(rs.getString("file1"));
				hotel.setResdate(rs.getString("resdate"));
				hotel.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return hotel;
	}
	
	public void updateReadCount(int idx){
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.HOTEL_READCOUNT_UPDATE);
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
	
	public int insertHotel(Hotel hotel){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.INSERT_HOTEL);
			pstmt.setString(1, hotel.getTitle());
			pstmt.setString(2, hotel.getContent());
			pstmt.setString(3, hotel.getAuthor());
			pstmt.setString(4, "data/"+hotel.getFile1());
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
	
	public Hotel updateHotel(int idx){
		Hotel hotel = new Hotel();
		User user = new User();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 hotel에 저장
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.HOTEL_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				hotel.setIdx(rs.getInt("idx"));
				hotel.setTitle(rs.getString("title"));
				hotel.setContent(rs.getString("content"));
				hotel.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				hotel.setName(user.getName());
				hotel.setFile1(rs.getString("file1"));
				hotel.setResdate(rs.getString("resdate"));
				hotel.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e){	
			e.printStackTrace();			
		} catch (Exception e){	
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return hotel;
	}

	public int updateHotelPro(Hotel hotel) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			if(hotel.getFile1()==null) {
				pstmt = con.prepareStatement(MySQL8.UPDATE_HOTEL2);
				pstmt.setString(1, hotel.getTitle());
				pstmt.setString(2, hotel.getContent());
				pstmt.setInt(3, hotel.getIdx());
			} else {
				pstmt = con.prepareStatement(MySQL8.UPDATE_HOTEL);
				pstmt.setString(1, hotel.getTitle());
				pstmt.setString(2, hotel.getContent());
				pstmt.setString(3, hotel.getFile1());
				pstmt.setInt(4, hotel.getIdx());
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

	public int deleteHotel(int idx) {
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.DELETE_HOTEL);
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
