package com.beyontec.mol.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateSerializer extends JsonSerializer<Date> {

	@Value("${date.format}")
	private String dateFormat;

	public CustomDateSerializer() {

	}

	public CustomDateSerializer(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {

		final SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		if (value == null) {
			gen.writeNull();
		} else {
			gen.writeString(formatter.format(value.getTime()));
		}
	}
}
