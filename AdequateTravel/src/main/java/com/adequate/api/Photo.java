package com.adequate.api;

import org.springframework.web.client.RestTemplate;

public class Photo {
	
	private String photo_reference;

	public Photo() {
		super();
	}

	public Photo(String photo_reference) {
		super();
		this.photo_reference = photo_reference;
	}

	public String getPhoto_reference() {
		return photo_reference;
	}

	public void setPhoto_reference(String photo_reference) {
		this.photo_reference = photo_reference;
	}
	

	@Override
	public String toString() {
		return "Photos [photo_reference=" + photo_reference + "]";
	}
}
