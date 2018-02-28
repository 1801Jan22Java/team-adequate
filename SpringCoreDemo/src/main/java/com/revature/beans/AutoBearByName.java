package com.revature.beans;

public class AutoBearByName extends Bear {

	private Cave cave;

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	@Override
	public void methodInBear() {
		System.out.println("Method in AutoBearByName is :" + this.toString());
		System.out.println("Cave: " + cave.toString());

	}

}
