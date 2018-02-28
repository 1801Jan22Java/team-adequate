package com.revature.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cave implements InitializingBean, DisposableBean{
	
	public Cave(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Cave() {
		super();
	}

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void destroy() throws Exception {
		System.out.println("Destroy disposableBean from cave");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("after properties set from InitializingBean cave");
	}
	
	public void defaultInit() {
		System.out.println("custom default init from cave");
	}
	
	public void defaultDestroy() {
		System.out.println("Custom default destroy from Cave");
	}
	
}
