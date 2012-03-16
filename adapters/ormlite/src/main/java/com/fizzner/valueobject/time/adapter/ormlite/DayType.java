package com.fizzner.valueobject.time.adapter.ormlite;

import com.fizzner.valueobject.time.Day;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BaseDateType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/**
 * @author Lukasz Strzelecki
 * @since 0.0.2
 */
public class DayType extends BaseDateType {

	private static final DayType singleTon = new DayType();

	public static DayType getSingleton() {
		return singleTon;
	}

	private DayType() {
		super(SqlType.LONG, new Class<?>[0]);
	}

	@Override
	public Object parseDefaultString(FieldType fieldType, String defaultStr) throws SQLException {
		try {
			return Long.parseLong(defaultStr);
		} catch (NumberFormatException e) {
			throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default date-long value: "
					+ defaultStr, e);
		}
	}

	@Override
	public Object resultToSqlArg(FieldType fieldType, DatabaseResults results, int columnPos) throws SQLException {
		return results.getLong(columnPos);
	}

	@Override
	public Object sqlArgToJava(FieldType fieldType, Object sqlArg, int columnPos) {
		return Day.fromMillis((Long)sqlArg);
	}

	@Override
	public Object javaToSqlArg(FieldType fieldType, Object obj) {
		Day date = (Day) obj;
		return date.asMilliseconds();
	}

	@Override
	public boolean isEscapedValue() {
		return false;
	}
}
