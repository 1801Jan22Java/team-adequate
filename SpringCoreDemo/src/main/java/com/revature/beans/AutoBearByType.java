package com.revature.beans;

public class AutoBearByType extends Bear {

	private Cave cave;

	// this is fine because we're wiring by type, not name
	// wouldn't work so well with multiple dependencies that are all the same type
	public void setSomethingWhichHasTypeCave(Cave somethingElse) {
		this.cave = somethingElse;
	}

	@Override
	public void methodInBear() {
		System.out.println("Method in AutoBearByName is :" + this.toString());
		System.out.println("Cave: " + cave.toString());

	}

}
