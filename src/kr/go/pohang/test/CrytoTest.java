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

import org.junit.Test;

public class CrytoTest {
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
	
	@Test
	public void test() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
		String data1 = cryptoEnc();
		System.out.println("암호화 : "+data1);
		String data2 = cryptoDes(data1);
		System.out.println("복호화 : "+data2);
		//fail("Not yet implemented");
	}

}
