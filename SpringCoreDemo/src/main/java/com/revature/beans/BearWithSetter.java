package com.revature.beans;

public class BearWithSetter extends Bear {

	private Cave cave;
	
	public void setCave(Cave cave) {
		this.cave = cave;
	}
	
	@Override
	public void methodInBear() {
		System.out.println("Method in BearWithSetter is :"+this.toString());
		System.out.println("Cave: "+cave.toString());

	}

}
