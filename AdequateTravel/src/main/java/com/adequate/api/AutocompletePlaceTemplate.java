package com.adequate.api;

import java.util.Arrays;

class PlaceDetail {

	private String description;
	private String place_id;

	public PlaceDetail() {
		super();
	}

	public PlaceDetail(String description, String place_id) {
		super();
		this.description = description;
		this.place_id = place_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	@Override
	public String toString() {
		return "PlaceDetail [description=" + description + ", place_id=" + place_id + "]";
	}

}

public class AutocompletePlaceTemplate {

	private String status;
	private PlaceDetail [] predictions;

	public AutocompletePlaceTemplate() {
		super();
	}

	public AutocompletePlaceTemplate(String status, PlaceDetail[] predictions) {
		super();
		this.status = status;
		this.predictions = predictions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PlaceDetail[] getPredictions() {
		return predictions;
	}

	public void setPredictions(PlaceDetail[] predictions) {
		this.predictions = predictions;
	}

	@Override
	public String toString() {
		return "PlaceTemplate [status=" + status + ", predictions=" + Arrays.toString(predictions) + "]";
	}



}
