/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
		return Day.fromMillis((Long) sqlArg);
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
