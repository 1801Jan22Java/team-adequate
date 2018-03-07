package com.adequate.api;

import java.util.Arrays;

class Geometry {
	private LatLong location;

	public LatLong getLocation() {
		return location;
	}

	public void setLocation(LatLong location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Geometry [location=" + location + "]";
	}
	
	
	
	
}

class Results {

	private Geometry geometry;

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@Override
	public String toString() {
		return "Results [geometry=" + geometry + "]";
	}
	
}

public class LatLongTemplate {
	private String status;
	private Results [] results;
	

	@Override
	public String toString() {
		return "LatLongTemplate [status=" + status + ", results=" + Arrays.toString(results) + "]";
	}

	public LatLongTemplate(String status, Results[] results) {
		super();
		this.status = status;
		this.results = results;
	}

	public LatLongTemplate() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Results[] getResults() {
		return results;
	}

	public void setResults(Results[] results) {
		this.results = results;
	}


	


}
