package kr.go.pohang.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


import kr.go.pohang.util.AES256;

//import org.junit.Assert;
import org.junit.Test;

public class LogTest {
	String id = "admin";
	String pw = "1234";
	String trans_pw1 = "";
	String trans_pw2 = "";
	String pat = "%02x";
	
	public String cryptoEnc() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException{
		trans_pw1 = AES256.encryptAES256(pw, pat);
		return trans_pw1;
	}
	
	public String cryptoDes(String pw) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
		trans_pw2 = AES256.decryptAES256(pw, pat);
		return trans_pw2;
	}
	
	public String login(String id, String pw) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException{
		String data1 = cryptoEnc();	//암호화
		String data2 = cryptoDes(data1);	//복호화
		String res = "";
		if(pw.equals(data2) && id.equals(this.id)){
			res = "pass";
		} else {
			res = "not pass";
		}
		return res;
	}
	
	private String logout(String sid) {
		String res = "";
		if(sid!=null){
			res = "logout";
		} else {
			res = "logout failure";
		}
		return res;
	}
	
	@Test
	public void test1() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
		System.out.println("로그인 테스트");
		String res = login("admin", "1234");
		if(res.equals("pass")){
			System.out.println("로그인 아이디 : "+id);
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		//Assert.assertEquals(res, "pass");
	}


	@Test
	public void test2() {
		System.out.println("로그아웃 테스트");
		String msg = logout(id);
		if(msg.equals("logout")){
			System.out.println("로그아웃 성공");
		} else {
			System.out.println("로그아웃 실패");
		}
		//Assert.assertEquals(msg, "logout");
	}
}
