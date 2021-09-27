package com.example.commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class CustomTimestamp {

	private CustomTimestamp() {
	}

	public static DateFormat dfIn() {
		return new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
	}

	public static DateFormat dfOut() {
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

}
