package com.example.entity;

public enum Currency {

	EUR("Euro"), USD("Dólar estadounidense");

	public final String description;

	private Currency(String description) {
		this.description = description;
	}

}
