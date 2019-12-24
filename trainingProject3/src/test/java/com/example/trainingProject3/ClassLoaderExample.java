package com.example.trainingProject3;

public class ClassLoaderExample {

	public void getClassLoaderName() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		System.out.println("class: " + cl.getClass() + ", parent: " + cl.getParent()+", cl: "+cl);
	}
}
