package org.example;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

public class BaseRecord implements java.io.Serializable {
    private final String tag;
    private final String description;
    private String value;
    protected Character type = Definitions.DATA_RECORD;
    protected boolean repeatable = true;

    public BaseRecord(String tag, String description, String value) {
        this.tag = tag;
        this.description = description;
        this.value = value;
    }

    public BaseRecord copy() {
        BaseRecord r = new BaseRecord(tag, description, value);
        r.type = type;
        r.repeatable = repeatable;
        return r;
    }

    public String getTag() {
        return tag;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRepeatable() {
       return repeatable;
    }

    public Character getType() {
        return type;
    }

    public boolean isControl() {
        return type.equals(Definitions.CONTROL_RECORD);
    }

    public boolean isData() {
        return type.equals(Definitions.DATA_RECORD);
    }

    public String toString() {
        return tag + " " + value;
    }

    public String toString(boolean debug) {
        if (debug) {
            return tag + " " + description + " " + value;
        } else {
            return tag + " " + value;
        }
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        Map<String, String> properties = new HashMap<>();
        properties.put("tag", tag);
        properties.put("value", value);
        properties.put("description", description);
        properties.put("type", type.toString());
        properties.put("repeatable", String.valueOf(repeatable));
        return properties;
    }
}
