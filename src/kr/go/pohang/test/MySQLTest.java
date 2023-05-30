package kr.go.pohang.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.go.pohang.util.MySQL8;

import org.junit.Test;

public class MySQLTest {
	public Connection con = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	String sql = "";
	
	@Test
	public void test1() {
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.SAMPLE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("item1"));
				System.out.println(rs.getInt("item2"));
				System.out.println(rs.getString("item3"));
				System.out.println("*****************************************");
			}
		} catch(Exception e){
			System.out.println("데이터베이스 연동 실패");
		}
	}
}
