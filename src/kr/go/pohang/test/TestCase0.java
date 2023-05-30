package kr.go.pohang.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCase0 {

	/*
	@BeforeClass
	public void testClass(){
		System.out.println("아직 클래스 전입니다.");
	} */
	
	@Before
	public void testBefore(){
		System.out.println("아직 테스트 전입니다.");
	}
	
	@Test
	public void test1() {
		System.out.println("테스트1 입니다.");
		//fail("Not yet implemented");
	}

	@Test
	public void test2() {
		System.out.println("테스트2 입니다.");
		//fail("Not yet implemented");
	}
	
	@After
	public void testAfter(){
		System.out.println("테스트 후 입니다.");
	}
	
//	@AfterClass
//	public void testClass2(){
//		System.out.println("클래스 후 입니다.");
//	}
}
