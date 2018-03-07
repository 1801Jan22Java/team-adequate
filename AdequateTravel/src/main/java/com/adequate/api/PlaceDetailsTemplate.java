package com.adequate.api;

import java.util.Arrays;


class PlaceDetailResult {
	private String name;
	private String[] types;
	private Photo[] photos;

	private String formatted_address;
	private String formatted_phone_number;
	private int price_level;

	public PlaceDetailResult() {
		super();
	}

	public PlaceDetailResult(String name, String[] types, Photo[] photos, String formatted_address, String formatted_phone_number,
			int price_level) {
		super();
		this.name = name;
		this.types = types;
		this.photos = photos;
		this.formatted_address = formatted_address;
		this.formatted_phone_number = formatted_phone_number;
		this.price_level = price_level;
	}

	public Photo[] getPhotos() {
		return photos;
	}

	public void setPhotos(Photo[] photos) {
		this.photos = photos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getFormatted_phone_number() {
		return formatted_phone_number;
	}

	public void setFormatted_phone_number(String formatted_phone_number) {
		this.formatted_phone_number = formatted_phone_number;
	}

	public int getPrice_level() {
		return price_level;
	}

	public void setPrice_level(int price_level) {
		this.price_level = price_level;
	}

	@Override
	public String toString() {
		return "PlaceDetailResult [name=" + name + ", types=" + Arrays.toString(types) + ", photos=" + Arrays.toString(photos)
				+ ", formatted_address=" + formatted_address + ", formatted_phone_number=" + formatted_phone_number
				+ ", price_level=" + price_level + "]";
	}


}

public class PlaceDetailsTemplate {

	private String status;
	private PlaceDetailResult result;

	public PlaceDetailsTemplate() {
		super();
	}

	public PlaceDetailsTemplate(String status, PlaceDetailResult result) {
		super();
		this.status = status;
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PlaceDetailResult getResult() {
		return result;
	}

	public void setResult(PlaceDetailResult result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "PlaceDetailsTemplate [status=" + status + ", result=" + result + "]";
	}

}
