package org.example.proto.Domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Data {
    private JsonNode jsonData;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Data(String jsonString) {
        stelJsonDataIn(jsonString);
    }

    public void stelJsonDataIn(String jsonString) {
        try {
            this.jsonData = objectMapper.readTree(jsonString);
        } catch (Exception e) {
            throw new IllegalArgumentException("Ongeldige JSON-string", e);
        }
    }

    public String haalJsonDataOp() {
        return jsonData.toString();
    }

    public JsonNode haalJsonNodeOp() {
        return jsonData;
    }
}
