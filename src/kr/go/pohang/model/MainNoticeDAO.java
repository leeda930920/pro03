package kr.go.pohang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.pohang.model.MySQL8;
import kr.go.pohang.model.UserDAO;
import kr.go.pohang.dto.Notice;
import kr.go.pohang.dto.User;

public class MainNoticeDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	UserDAO udao = new UserDAO();
	
	public ArrayList<Notice> noticeListAll(){
		ArrayList<Notice> notiList2 = new ArrayList<Notice>();
		//notice 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 notiList에 add를 한다.
		try {
			con = MySQL8.getConnection();
			pstmt = con.prepareStatement(MySQL8.NOTICE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				Notice noti2 = new Notice();
				noti2.setIdx(rs.getInt("idx"));
				noti2.setTitle(rs.getString("title"));
				noti2.setContent(rs.getString("content"));
				noti2.setAuthor(rs.getString("author"));
				user = udao.myInfo(rs.getString("author"));
				noti2.setName(user.getName());
				noti2.setFile1(rs.getString("file1"));
				noti2.setResdate(rs.getString("resdate"));
				noti2.setReadcnt(rs.getInt("readcnt"));
				notiList2.add(noti2);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(rs, pstmt, con);
		return notiList2;
	}
	
}
