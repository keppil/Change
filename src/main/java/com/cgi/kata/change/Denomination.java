package com.cgi.kata.change;

public enum Denomination {
	ONE(1), FIVE(5), TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100), TWO_HUNDRED(200);
	private int value;

	private Denomination(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
