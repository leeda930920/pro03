package kr.go.pohang.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.go.pohang.util.MySQL8;

public class SampleDAO {
	public Connection con = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	String sql = "";
	ArrayList<Sample1> samList = new ArrayList<Sample1>();
	//샘플 목록
	public ArrayList<Sample1> getSampleList(){
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SAMPLE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Sample1 sam = new Sample1();
				sam.setItem1(rs.getString("item1"));
				sam.setItem2(rs.getInt("item2"));
				sam.setItem3(rs.getString("item3"));
				samList.add(sam);
			}
		} catch(Exception e){
			System.out.println("데이터베이스 연동 실패");
		}
		return samList;
	}
	//샘플 레코드 하나
	public Sample1 getSample(String item1){
		Sample1 sam = new Sample1();
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SAMPLE_SELECT_ONE);
			pstmt.setString(1, item1);
			rs = pstmt.executeQuery();
			if(rs.next()){
				sam.setItem1(rs.getString("item1"));
				sam.setItem2(rs.getInt("item2"));
				sam.setItem3(rs.getString("item3"));
			}
		} catch(Exception e){
			System.out.println("데이터베이스 연동 실패");
		}
		return sam;
	}
	//샘플 추가
	public int addSample(Sample1 sam){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SAMPLE_INSERT);
			pstmt.setString(1, sam.getItem1());
			pstmt.setInt(2, sam.getItem2());
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			System.out.println("데이터베이스 연동 실패");
		}
		return cnt;
	}
	//샘플 변경
	public int updateSample(Sample1 sam){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SAMPLE_UPDATE);
			pstmt.setInt(1, sam.getItem2());
			pstmt.setString(2, sam.getItem1());
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			System.out.println("데이터베이스 연동 실패");
		}
		return cnt;
	}
	//샘플 삭제
	public int deleteSample(String item1){
		int cnt = 0;
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SAMPLE_DELETE);
			pstmt.setString(1, item1);
			cnt = pstmt.executeUpdate();
		} catch(Exception e){
			System.out.println("데이터베이스 연동 실패");
		}
		return cnt;
	}
}
