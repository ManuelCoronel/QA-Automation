package com.sophossolutions.models;

public class Origin {
	private String name, url;

	public Origin(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	
	public Origin() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
