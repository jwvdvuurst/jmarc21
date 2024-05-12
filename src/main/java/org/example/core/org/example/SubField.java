package org.example;

public class SubField {
    private String subtag;
    private String description;
    private boolean repeatable;
    private String value;

    public SubField(String subtag, boolean repeatable, String description) {
        this.subtag = subtag;
        this.repeatable = repeatable;
        this.description = description;
        this.value = "";
    }

    public SubField copy() {
        SubField sf = new SubField(subtag, repeatable, description);
        this.value = "";
        return sf;
    }

    public String getSubtag() {
        return subtag;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return "$" + subtag + " " + value;
    }

    public String toString(boolean debug) {
        String description = (debug) ? "(" + this.description + ") " : "";

        return "$" + subtag + " " + description + value;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public String getDescription() {
        return description;
    }
}
