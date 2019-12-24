package com.example.trainingProject3;

public class Caller extends Thread {

	public void run() {
		new ClassLoaderExample().getClassLoaderName();
	}

	public static void main(String a[]) {
		new Caller().start();
	}
}
