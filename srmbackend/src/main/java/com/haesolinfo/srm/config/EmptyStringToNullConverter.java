package com.haesolinfo.srm.config;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Slf4j
@Converter(autoApply = false)
public class EmptyStringToNullConverter implements AttributeConverter<Object, Double> {

    @Override
    public Double convertToDatabaseColumn(Object attribute) {

        if(attribute != null && attribute.toString().length() > 0){
            try {
                return Double.parseDouble(attribute.toString());
            }catch (Exception e){
                return 0.0;
            }
        }

        return 0.0;
    }

    @Override
    public String convertToEntityAttribute(Double dbData) {
        return dbData.toString();
    }
}
