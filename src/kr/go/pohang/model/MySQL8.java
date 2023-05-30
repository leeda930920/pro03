package kr.go.pohang.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL8 {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/pohang?serverTimezone=Asia/Seoul";
	static String user = "root";
	static String pass = "1234";
	
	//회원
	final static String USER_SELECT_ALL = "select * from user order by regdate desc";
	final static String USER_LOGIN =  "select * from user where id=?";
	final static String INSET_USER = "insert into user(id, pw, name, tel, addr, email) values (?,?,?,?,?,?)";
	final static String UPDATE_USER = "update user set pw=?, name=?, tel=?, addr=?, email=? where id=?";
	final static String UPDATE_USER2 = "update user set name=?, tel=?, addr=?, email=? where id=?";
	final static String DELETE_USER = "delete from user where id=?";
	final static String USER_SELECT_TEL = "select tel from user where id=?";
	final static String UPDATE_PW_RESET = "update user set pw=? where id=?";
	
	public final static String LOAD_LAST_NO = "select no from tour order by no desc limit 1";
	public final static String FILE_UPLOAD = "insert into pic(tourno, picname, pos) values (?,?,?)";
	public final static String JSON_PICLIST = "select * from pic where tourno=?";
	public final static String PIC_SELECT_ONE = "select * from pic where tourno=? order by pos asc limit 1";
	public final static String ADD_TOUR = "insert into tour(tourno, cate, place, comment1, comment2, addr) values (?,?,?,?,?,?)";
	public final static String TOUR_LIST_ALL = "select * from tour order by no desc";
	public final static String TOUR_IMPRESS_PLACE = "select * from tour where tourno=?";
	public final static String TOUR_CATE_LIST = "select a.no, a.tourno, a.cate, a.place, a.comment1, a.comment2, b.picname, b.pos from tour a inner join pic b on a.tourno=b.tourno where a.cate=? and b.pos=1";
	
	
	//공지사항
	final static String NOTICE_SELECT_ALL = "select * from notice order by idx desc";
	final static String NOTICE_SELECT_ONE = "select * from notice where idx=?";
	final static String NOTICE_READCOUNT_UPDATE = "update notice set readcnt=readcnt+1 where idx=?";
	final static String INSERT_NOTICE = "insert into notice(title,content,author,file1,resdate,readcnt,ncate) values (?, ?, ?, ?, default, default, default)";
	final static String UPDATE_NOTICE = "update notice set title=?, content=?, file1=?, resdate=sysdate where idx=?";
	final static String UPDATE_NOTICE2 = "update notice set title=?, content=?, resdate=sysdate where idx=?";
	final static String DELETE_NOTICE = "delete from notice where idx=?";
	//대표축제	
	final static String FESTIVAL_SELECT_ALL = "select * from festival order by idx desc";
	final static String FESTIVAL_SELECT_ONE = "select * from festival where idx=?";
	final static String FESTIVAL_READCOUNT_UPDATE = "update festival set readcnt=readcnt+1 where idx=?";
	final static String INSERT_FESTIVAL = "insert into festival(title,content,author,file1,resdate,readcnt,ncate) values (?, ?, ?, ?, default, default, default)";
	final static String UPDATE_FESTIVAL = "update festival set title=?, content=?, file1=?, resdate=sysdate where idx=?";
	final static String UPDATE_FESTIVAL2 = "update festival set title=?, content=?, resdate=sysdate where idx=?";
	final static String DELETE_FESTIVAL = "delete from festival where idx=?";
	//전통시장
	final static String MARKET_SELECT_ALL = "select * from market order by idx desc";
	final static String MARKET_SELECT_ONE = "select * from market where idx=?";
	final static String MARKET_READCOUNT_UPDATE = "update market set readcnt=readcnt+1 where idx=?";
	final static String INSERT_MARKET = "insert into market values (noti_seq.nextval, ?, ?, ?, ?, default, default)";
	final static String UPDATE_MARKET = "update market set title=?, content=?, file1=?, resdate=sysdate where idx=?";
	final static String UPDATE_MARKET2 = "update market set title=?, content=?, resdate=sysdate where idx=?";
	final static String DELETE_MARKET = "delete from market where idx=?";
	//SNS
	final static String SNS_SELECT_ALL = "select * from sns order by idx desc";
	final static String SNS_SELECT_ONE = "select * from sns where idx=?";
	final static String SNS_READCOUNT_UPDATE = "update sns set readcnt=readcnt+1 where idx=?";
	final static String INSERT_SNS = "insert into sns values (noti_seq.nextval, ?, ?, ?, ?, default, default)";
	final static String UPDATE_SNS = "update sns set title=?, content=?, file1=?, resdate=sysdate where idx=?";
	final static String UPDATE_SNS2 = "update sns set title=?, content=?, resdate=sysdate where idx=?";
	final static String DELETE_SNS = "delete from sns where idx=?";
	//음식점
	final static String FOOD_SELECT_ALL = "select * from food order by idx desc";
	final static String FOOD_SELECT_ONE = "select * from food where idx=?";
	final static String FOOD_READCOUNT_UPDATE = "update food set readcnt=readcnt+1 where idx=?";
	final static String INSERT_FOOD = "insert into food values (noti_seq.nextval, ?, ?, ?, ?, default, default)";
	final static String UPDATE_FOOD = "update food set title=?, content=?, file1=?, resdate=sysdate where idx=?";
	final static String UPDATE_FOOD2 = "update food set title=?, content=?, resdate=sysdate where idx=?";
	final static String DELETE_FOOD = "delete from food where idx=?";
	
	//숙박
	final static String HOTEL_SELECT_ALL = "select * from hotel order by idx desc";
	final static String HOTEL_SELECT_ONE = "select * from hotel where idx=?";
	final static String HOTEL_READCOUNT_UPDATE = "update hotel set readcnt=readcnt+1 where idx=?";
	final static String INSERT_HOTEL = "insert into hotel values (noti_seq.nextval, ?, ?, ?, ?, default, default)";
	final static String UPDATE_HOTEL = "update hotel set title=?, content=?, file1=?, resdate=sysdate where idx=?";
	final static String UPDATE_HOTEL2 = "update hotel set title=?, content=?, resdate=sysdate where idx=?";
	final static String DELETE_HOTEL = "delete from hotel where idx=?";
	
	//문화관광
	final static String CULTURE_SELECT_ALL = "select * from culture order by idx desc";
	final static String CULTURE_SELECT_ONE = "select * from culture where idx=?";
	final static String CULTURE_READCOUNT_UPDATE = "update culture set readcnt=readcnt+1 where idx=?";
	final static String INSERT_CULTURE = "insert into culture values (noti_seq.nextval, ?, ?, ?, ?, default, default)";
	final static String UPDATE_CULTURE = "update culture set title=?, content=?, file1=?, resdate=sysdate where idx=?";
	final static String UPDATE_CULTURE2 = "update culture set title=?, content=?, resdate=sysdate where idx=?";
	final static String DELETE_CULTURE = "delete from culture where idx=?";
	
	//레저
	final static String LEISURE_SELECT_ALL = "select * from leisure order by idx desc";
	final static String LEISURE_SELECT_ONE = "select * from leisure where idx=?";
	final static String LEISURE_READCOUNT_UPDATE = "update leisure set readcnt=readcnt+1 where idx=?";
	final static String INSERT_LEISURE = "insert into leisure values (noti_seq.nextval, ?, ?, ?, ?, default, default)";
	final static String UPDATE_LEISURE = "update leisure set title=?, content=?, file1=?, resdate=sysdate where idx=?";
	final static String UPDATE_LEISURE2 = "update leisure set title=?, content=?, resdate=sysdate where idx=?";
	final static String DELETE_LEISURE = "delete from leisure where idx=?";
	
	//관광지
	final static String TOURIST_SELECT_ALL = "select * from tourist order by idx desc";
	final static String TOURIST_SELECT_ONE = "select * from tourist where idx=?";
	final static String TOURIST_READCOUNT_UPDATE = "update tourist set readcnt=readcnt+1 where idx=?";
	final static String INSERT_TOURIST = "insert into tourist values (noti_seq.nextval, ?, ?, ?, ?, default, default)";
	final static String UPDATE_TOURIST = "update tourist set title=?, content=?, file1=?, resdate=sysdate where idx=?";
	final static String UPDATE_TOURIST2 = "update tourist set title=?, content=?, resdate=sysdate where idx=?";
	final static String DELETE_TOURIST = "delete from tourist where idx=?";
	
	//상품
	final static String PRODUCT_CATENAME_SELECT = "select * from category where cate=?";
	final static String PRODUCT_SELECT_ALL = "select * from product order by pcode desc";
	final static String PRODUCT_SELECT = "select * from product where pcode=?";
	final static String PRODUCT_SOLDOUT_SELECT = "select * from product where amount<=0";
	final static String PRODUCT_CATE_SELECT = "select * from product where cate=?";
	final static String PRODUCT_CATE_SELECT2 = "select * from product where cate like ?||'%'";
	final static String PRODUCT_CATE_SELECT3 = "select * from product where cate like concat(?, '%')";
	final static String FIRST_CATEGORY_SELECT = "select distinct substr(cate,1,2) as ct, categroup from category group by substr(cate,1,2), categroup order by ct";
	final static String SECOND_CATEGORY_SELECT = "select cate, catename from category where cate like ?||'%' order by cate";
	final static String PCODE_GENERATOR = "select pcode from (select * from product where cate=? order by pcode desc) where rownum = 1";
	final static String INSERT_PRODUCT = "insert into product values(?,?,?,?,?,?)";
	final static String RECEIPT_PRODUCT = "update product set amount=amount+?, price=? where pcode=?";
	final static String UPDATE_PRODUCT = "update product set amount=amount+?, price=? where pcode=?";
	final static String UPDATE_PRODUCT2 = "update product set pname=?, pstd=?, price=?, pcom=?, amount=?, pic1=?, pic2=?, pic3=?, utburl=?, bookidx=?, cate=? where pcode=?";
	final static String SALES_PRODUCT = "update product set amount=amount-? where pcode=?";
	final static String DELETE_PRODUCT = "delete from product where pcode=?";
	
	final static String QNO_GENERATOR = "select qno from (select * from qna order by qno desc) where rownum = 1";
	final static String ADD_QNA = "insert into qna values (?,?,?,?,sysdate,1,?,0)";
	final static String ADD_REPLY = "insert into qna values (?,?,?,?,sysdate,2,?,0)";
	final static String QNA_LIST = "select * from qna order by parno desc, qno asc";
	final static String QNA_SELECT = "select * from qna where parno=? order by qno asc";
	final static String QNA_SELECT_ONE = "select * from qna where qno=?";
	final static String REPLY_LIST = "select * from qna where parno=? and lev=2 order by qno asc";
	final static String REPLY_SELECT = "select * from qna where parno=? and lev=2 order by qno asc";
	final static String REPLY_SELECT_ONE = "select * from qna where lev=2 and qno=? order by qno asc";
	final static String UPDATE_QNA = "update qna set title=?, content=? where qno=?";
	final static String DELETE_QNA = "delete from qna where parno=?";
	final static String DELETE_REPLY = "delete from qna where qno=?";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}
	public static void close(PreparedStatement pstmt, Connection con){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
