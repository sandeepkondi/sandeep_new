package com.beyontec.mol.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

	@Value("${date.format}")
	private String dateFormat;

	public CustomDateDeserializer() {

	}

	public CustomDateDeserializer(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	@Override
	public Date deserialize(JsonParser jsonparser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(dateFormat, Locale.ENGLISH);
		try {
			LocalDateTime ldt = LocalDateTime.parse(jsonparser.getText(), fomatter);
			return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		} catch (DateTimeParseException e) {
			try {
				LocalDate ld = LocalDate.parse(jsonparser.getText(), fomatter);
				return Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
			} catch (DateTimeParseException exp) {
				try {
					LocalTime lt = LocalTime.parse(jsonparser.getText(), fomatter);
					Calendar calendar = Calendar.getInstance();
					calendar.clear();
					calendar.set(0, 0, 0, lt.getHour(), lt.getMinute(), lt.getSecond());
					return calendar.getTime();
				} catch (DateTimeParseException e2) {
					return null;
				}
			}
		}
	}
}
