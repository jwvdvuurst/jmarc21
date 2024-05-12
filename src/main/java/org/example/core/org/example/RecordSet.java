package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RecordSet {

    private List<BaseRecord> records;

    public RecordSet() {
        records = new ArrayList<BaseRecord>();
    }

    public RecordSet(RecordSet rs) {
        records = new ArrayList<BaseRecord>();
        for(BaseRecord r : rs.getRecords()) {
            records.add(r.copy());
        }
    }

    public List<BaseRecord> getRecords() {
        return Collections.unmodifiableList(records);
    }

    public BaseRecord addRecord(String tag) throws Marc21Exception {
        BaseRecord r = Marc21Dictionary.getInstance().getRecord(tag);

        if (r == null) {
            throw new Marc21Exception("Record not found for tag: " + tag);
        }

        if (!r.isRepeatable()) {
            for (BaseRecord record : records) {
                if (record.getTag().equals(tag)) {
                    throw new Marc21Exception("Non-repeatable record already exists for tag: " + tag);
                }
            }
        }

        BaseRecord br;

        if (r.getType() == Definitions.CONTROL_RECORD) {
            br = new ControlRecord(r.getTag(), r.getDescription(), null);
        } else {
            br = new DataRecord(r.getTag(), r.getDescription());
        }

        records.add(br);
        return br;
    }

    public String toString() {
        return String.join("\n", records.stream().map(BaseRecord::toString).collect(Collectors.toList()));
    }

}
