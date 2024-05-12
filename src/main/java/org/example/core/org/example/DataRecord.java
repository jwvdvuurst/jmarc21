package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DataRecord extends BaseRecord {

    private List<SubField> subfields = new ArrayList<SubField>();
    private boolean repeatable = true;
    private Character Indicator1;
    private Character Indicator2;

    public DataRecord(String tag, String description) {
        super(tag, description, "");
        type = Definitions.DATA_RECORD;
    }

    public DataRecord(String tag, boolean repeatable,String description) {
        super(tag, description, "");
        this.repeatable = repeatable;
        type = Definitions.DATA_RECORD;
    }

    public DataRecord copy() {
        DataRecord r = (DataRecord)super.copy();
        r.repeatable = repeatable;
        r.Indicator1 = Indicator1;
        r.Indicator2 = Indicator2;

        for( SubField sf : subfields ) {
            r.subfields.add(sf.copy());
        }
        return r;
    }

    public DataRecord setIndicators(Character Indicator1, Character Indicator2) {
        this.Indicator1 = Indicator1;
        this.Indicator2 = Indicator2;
        return this;
    }

    public DataRecord addSubField(SubField sf) {
        subfields.add(sf);
        return this;
    }
    public boolean addSubField(String subtag, boolean repeatable, String description) {
        subfields.add(new SubField(subtag, repeatable, description));
        return true;
    }

    public DataRecord addSubField(String subtag, String value) throws Marc21Exception {
        DataRecord dataRecord = (DataRecord)Marc21Dictionary.getInstance().getRecord(getTag());
        SubField sf = getSubField(subtag, dataRecord);

        if (!sf.isRepeatable()) {
            for( SubField f : subfields ) {
                if (f.getSubtag().equals(subtag)) {
                    throw new Marc21Exception("Subfield "+subtag+" is not repeatable for tag " + getTag());
                }
            }
        }

        SubField newField = sf.copy();
        newField.setValue(value);
        subfields.add(newField);
        return this;
    }

    private @NotNull SubField getSubField(String subtag, DataRecord dataRecord) throws Marc21Exception {
        List<SubField> fields = dataRecord.getSubfields();

        if (fields == null) {
            throw new Marc21Exception("Tag " + getTag() + " has no subfields defined");
        }

        SubField sf = null;

        for( SubField f : fields ) {
            if (f.getSubtag().equals(subtag)) {
                sf = f;
                break;
            }
        }

        if (sf == null) {
            throw new Marc21Exception("Subfield "+ subtag +" not found for tag " + getTag());
        }
        return sf;
    }

    public void setValue(String value) {
        super.setValue(value);
    }

    @Override
    public String toString() {
        StringBuilder fields = new StringBuilder();

        for( SubField sf : subfields ) {
            if (!fields.isEmpty()) {
                fields.append(" ");
            }
            fields.append(sf.toString());
        }

        return getTag() + " " + fields;
    }

    public Character getIndicator1() {
        return Indicator1;
    }

    public Character getIndicator2() {
        return Indicator2;
    }

    public List<SubField> getSubfields() {
        return subfields;
    }
}
