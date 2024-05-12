package org.example;

import org.jetbrains.annotations.Nullable;

public class ControlRecord extends BaseRecord {
    public ControlRecord(String tag, String description, @Nullable String value) {
        super(tag, description, "");
        type = Definitions.CONTROL_RECORD;
        repeatable=false;
        if (value != null) {
            setValue(value);
        }
    }
}
