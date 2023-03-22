package com.sophossolutions.models;

public class Location {
	private String name, url;

	public Location(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}

	public Location() {
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
