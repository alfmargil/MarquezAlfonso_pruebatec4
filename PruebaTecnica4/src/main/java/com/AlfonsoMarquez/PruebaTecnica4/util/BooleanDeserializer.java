package com.AlfonsoMarquez.PruebaTecnica4.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class BooleanDeserializer extends JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, IOException {
        String value = p.getValueAsString();
        return "YES".equalsIgnoreCase(value) || "true".equalsIgnoreCase(value);
    }
}
