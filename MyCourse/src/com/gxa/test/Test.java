package com.gxa.test;

public class Test {
   private static String x="0";
	
	public static void test1(String y){
		
		System.out.println(x);
		x=y;
		System.out.println(x);
		
	}
	public static void test2(){
		System.out.println(x);
	}
	public static void main(String[] args) {
		Test t = new Test();
		test1("5");
		test2();
	}
}
