package com.beyontec.mol.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanAttributeConverter implements AttributeConverter<Boolean, Character> {

    @Override
    public Character convertToDatabaseColumn(Boolean attribute) {
        return ((attribute != null) && (attribute == true)) ? 'Y' : 'F';
    }

    @Override
    public Boolean convertToEntityAttribute(Character dbData) {
        return ((dbData != null) && ('Y' == dbData));
    }
}
