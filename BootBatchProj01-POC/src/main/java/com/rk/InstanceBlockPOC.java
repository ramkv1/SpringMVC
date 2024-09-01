package com.rk;

class Test{
	public Test() {
		System.out.println("Test.Test()");
	}
	public void m1() {
		System.out.println("Test.m1()");
	}
}
public class InstanceBlockPOC {
	public static void main(String[] args) {
		Test test=new Test();
		test.m1();
		System.out.println("test obj class Name::"+test.getClass()+"Super class::"+test.getClass().getSuperclass());
		System.out.println("===========================");
		Test t1=new Test() {};
		t1.m1();
		System.out.println("t1 Obj class Name::"+t1.getClass()+"Super class::"+t1.getClass().getSuperclass());
		System.out.println("=============================");
		Test t2=new Test() {
			//constructor can not defined here, so go for instance block
			{
				m1();
			}
		};
		System.out.println("t2 Obj class Name::"+t2.getClass()+"Super class"+t2.getClass().getSuperclass());
	}
}
