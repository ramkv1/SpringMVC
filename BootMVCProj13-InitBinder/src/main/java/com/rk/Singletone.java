package com.rk;

class Animal{
	private static Animal single_instance=null;
	private Animal() {
		
	}
	public static Animal getInstance() {
		if(single_instance==null)
			single_instance=new  Animal();
		return single_instance;
	}
}
public class Singletone{
	public static void main(String[] args) {
		Animal animal1=Animal.getInstance();
		Animal animal2=Animal.getInstance();
		System.out.println(animal1.hashCode());
		System.out.println(animal2.hashCode());
		System.out.println(animal1==animal2);
	}
}
