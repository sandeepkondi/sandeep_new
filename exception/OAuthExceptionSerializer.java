package com.beyontec.mol.exception;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class OAuthExceptionSerializer extends StdSerializer<OAuthException> {

	private static final long serialVersionUID = 2339214806344276334L;

	public OAuthExceptionSerializer() {
		super(OAuthException.class);
	}

	@Override
	public void serialize(OAuthException value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {
		jsonGenerator.writeStartObject();
		ErrorDetail errorDetail = new ErrorDetail(String.valueOf(value.getHttpErrorCode()), value.getMessage());
		jsonGenerator.writeObjectField("errors", Arrays.asList(errorDetail));
		if (value.getAdditionalInformation() != null) {
			for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
				String key = entry.getKey();
				String add = entry.getValue();
				jsonGenerator.writeStringField(key, add);
			}
		}
		jsonGenerator.writeEndObject();
	}
}
