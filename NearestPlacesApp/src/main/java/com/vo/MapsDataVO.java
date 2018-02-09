package com.vo;

import java.io.Serializable;

public class MapsDataVO implements Serializable{

	private static final long serialVersionUID = 1938494088481543214L;
	
	private String placeType;
	private String city;
	public String getPlaceType() {
		return placeType;
	}
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
