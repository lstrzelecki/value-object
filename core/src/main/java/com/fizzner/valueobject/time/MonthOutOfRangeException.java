package com.fizzner.valueobject.time;

/**
 * @author Lukasz Strzelecki
 * @since 0.0.1
 */
public class MonthOutOfRangeException extends RuntimeException{
	public MonthOutOfRangeException(int monthNumber) {
		super("Wrong month number. Valid value is between [1,12], but was "+ monthNumber);
	}
}
