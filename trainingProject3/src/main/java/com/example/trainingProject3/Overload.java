package com.example.trainingProject3;

public class Overload {
	
	//arguement type -- int,int
	public void add(int a, int b) {
		System.out.println(a+b);
	}
	
	//arguement type -- float&int
	public void add(int praveen) {
		//System.out.println(praveen+teja);
		//System.out.println(a+b);
	}
	
	public static void  main(String a[]) {
		Overload obj1 = new Overload();
		//obj1.add(10, 20.1);
	}
}

