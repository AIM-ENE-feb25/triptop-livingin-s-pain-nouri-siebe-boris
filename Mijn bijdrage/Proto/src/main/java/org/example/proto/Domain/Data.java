package org.example.proto.Domain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;



public class Data extends HashMap<String, Object> {

    public Data(JsonNode jsonNode) {
        super();
        if (jsonNode != null) {
            jsonNode.fields().forEachRemaining(entry -> {
                this.put(entry.getKey(), getValueFromNode(entry.getValue()));
            });
        }
    }

    // AI Hulpmethode om waarden recursief uit te pakken en netjes op te slaan in db
    private Object getValueFromNode(JsonNode node) {
        if (node.isTextual()) {
            return node.asText();
        } else if (node.isNumber()) {
            return node.isInt() ? node.asInt() :
                    node.isLong() ? node.asLong() :
                            node.isDouble() ? node.asDouble() : node.numberValue();
        } else if (node.isBoolean()) {
            return node.asBoolean();
        } else if (node.isArray()) {
            List<Object> list = new ArrayList<>();
            node.elements().forEachRemaining(element -> list.add(getValueFromNode(element)));
            return list;
        } else if (node.isObject()) {
            Map<String, Object> map = new HashMap<>();
            node.fields().forEachRemaining(entry -> map.put(entry.getKey(), getValueFromNode(entry.getValue())));
            return map;
        } else {
            return null;
        }
    }
}
