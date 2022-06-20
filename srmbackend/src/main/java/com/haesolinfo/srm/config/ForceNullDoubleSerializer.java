package com.haesolinfo.srm.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ForceNullDoubleSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if(value == null || value.equals("")){
            gen.writeNumber(0.0);
        }else{
            gen.writeString(value);
        }
    }
}
