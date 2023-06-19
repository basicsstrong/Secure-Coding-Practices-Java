package com.basicsstrong.securecoding;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
	private String name;
    private int age;


    public void setName(String name) {
		this.name = name;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

