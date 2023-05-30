package kr.go.pohang.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.go.pohang.util.MySQL8;

import org.junit.Test;

public class DTOTest {
	public Connection con = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	String sql = "";
	ArrayList<Sample1> samList = new ArrayList<Sample1>();
	
	public ArrayList<Sample1> db(){
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
	
	@Test
	public void test() {
		ArrayList<Sample1> testList = db();
		for(Sample1 sam:testList){
			System.out.println("아이디 : "+sam.getItem1());
			System.out.println("포인트 : "+sam.getItem2());
			System.out.println("가입일 : "+sam.getItem3());
			System.out.println();
		}
		//fail("Not yet implemented");
	}
}

