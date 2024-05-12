package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        RecordSet rs = new RecordSet();
        String[] records = {"001", "002", "003", "004", "005", "006", "007", "008", "009", "010"};

        for( String rec : records ) {
            try {
                BaseRecord bs = rs.addRecord(rec);

                if (bs.isControl()) {
                    bs.setValue("test");
                } else {
                    DataRecord dr = (DataRecord) bs;
                    dr.addSubField("a", "test");
                }
            } catch (Marc21Exception e) {
                logger.error(e.getMessage());
            }

            try {
                rs.addRecord(rec);
            } catch (Marc21Exception e) {
                logger.error(e.getMessage());
            }
        }

        logger.info(rs.toString());

    }
}