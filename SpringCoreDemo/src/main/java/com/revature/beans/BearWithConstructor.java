package com.revature.beans;

public class BearWithConstructor extends Bear{
	
	private Cave cave;
	
	public BearWithConstructor() {
		super();
	}
	
	public BearWithConstructor(Cave cave) {
		this();
		this.cave=cave;
	}
	
	@Override
	public void methodInBear() {
		System.out.println("Method in BearWithConstructor is :"+this.toString());
		System.out.println("Cave: "+cave.toString());

	}
}
