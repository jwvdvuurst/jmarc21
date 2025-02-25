package org.example;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public final class Marc21Dictionary {

    private final Map<String, BaseRecord> records;
    private static volatile Marc21Dictionary instance = null;
    private final static Logger logger = LoggerFactory.getLogger(Marc21Dictionary.class);

    private Marc21Dictionary() {
        records = new HashMap<>();

        records.put("001", new ControlRecord("001", "Control Number", null));
        records.put("003", new ControlRecord("003", "Control Number Identifier", null));
        records.put("005", new ControlRecord("005", "Date and Time of Latest Transaction", null));
        records.put("006", new ControlRecord("006", "Fixed-Length Data  Elements - Additional Material Characteristics", null));
        records.put("007", new ControlRecord("007", "Physical Description Fixed Field-General Information", null));
        records.put("008", new ControlRecord("008", "Fixed-Length Data Elements", null));
        records.put("010", new DataRecord("010", false, "Library of Congress Number")
                .setIndicators(' ', ' ')
                .addSubField( new SubField("a", false, "LC control number"))
                .addSubField( new SubField("b", true, "NUCMC control number"))
                .addSubField( new SubField("z", true, "Cancelled/Invalid LC control number"))
                .addSubField( new SubField("8", true, "Field Link and Sequence number")));
        records.put( "011", new DataRecord( "011", "Library of Congress Control Number" )
                .setIndicators( ' ', ' ' )
                .addSubField( new SubField( "a", false, "Library of Congress Control Number" )));
        records.put( "013", new DataRecord( "013", true, "Patent Control Information" )
                .setIndicators( ' ', ' ' )
                .addSubField( new SubField( "a", false, "Patent Control Number" ))
                .addSubField( new SubField( "b", false, "Country" ))
                .addSubField( new SubField( "c", false, "Type of number" ))
                .addSubField( new SubField( "d", true, "Date" ))
                .addSubField( new SubField( "e", true, "Status information" ))
                .addSubField( new SubField( "f", true, "Party to document" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", true, "Field link and sequence number" )));
        records.put( "015", new DataRecord( "015", true, "National Bibliographic Number" )
                .setIndicators( ' ', ' ' )
                .addSubField( new SubField( "a", true, "National Bibliographic Number" ))
                .addSubField( new SubField( "q", true, "Qualifying information" ))
                .addSubField( new SubField( "z", true, "Canceled/invalid National Bibliographic Number" ))
                .addSubField( new SubField( "2", false, "Source" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", true, "Field link and sequence number" )));
        records.put( "018", new DataRecord( "018", "Copyright Article-Fee Code ")
                .addSubField( new SubField( "a", false, "Copyright article-fee code" ))
                .addSubField( new SubField( "6", false, "Linkage" )));
        records.put( "020", new DataRecord( "020", "International Standard Book Number ")
                .addSubField( new SubField( "a", false, "International Standard Book Number" ))
                .addSubField( new SubField( "c", false, "Terms of availability" ))
                .addSubField( new SubField( "q", false, "Qualifying information" ))
                .addSubField( new SubField( "z", false, "Canceled/invalid ISBN" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "022", new DataRecord( "022", "International Standard Serial Number ")
                .addSubField( new SubField( "a", false, "International Standard Serial Number" ))
                .addSubField( new SubField( "l", false, "ISSN-L" ))
                .addSubField( new SubField( "m", false, "Canceled ISSN-L" ))
                .addSubField( new SubField( "y", false, "Incorrect ISSN" ))
                .addSubField( new SubField( "z", false, "Canceled ISSN" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "024", new DataRecord( "024", "Other Standard Identifier ")
                .addSubField( new SubField( "a", false, "Standard number or code" ))
                .addSubField( new SubField( "c", false, "Terms of availability" ))
                .addSubField( new SubField( "d", false, "Additional codes following the standard number or code" ))
                .addSubField( new SubField( "q", false, "Qualifying information" ))
                .addSubField( new SubField( "z", false, "Canceled/invalid standard number or code" ))
                .addSubField( new SubField( "2", false, "Source of number or code" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "025", new DataRecord( "025", "Overseas Acquisition Number ")
                .addSubField( new SubField( "a", false, "Overseas acquisition number" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "026", new DataRecord( "026", "Fingerprint Identifier ")
                .addSubField( new SubField( "a", false, "First and second groups of characters" ))
                .addSubField( new SubField( "b", false, "Third and fourth groups of characters" ))
                .addSubField( new SubField( "c", false, "Date" ))
                .addSubField( new SubField( "d", false, "Number of volume or part" ))
                .addSubField( new SubField( "e", false, "Unparsed fingerprint" ))
                .addSubField( new SubField( "2", false, "Source" ))
                .addSubField( new SubField( "5", false, "Institution to which field applies" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "027", new DataRecord( "027", "Standard Technical Report Number ")
                .addSubField( new SubField( "a", false, "Standard technical report number" ))
                .addSubField( new SubField( "q", false, "Qualifying information" ))
                .addSubField( new SubField( "z", false, "Canceled/invalid number" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "028", new DataRecord( "028", "Publisher or Distributor Number ")
                .addSubField( new SubField( "a", false, "Publisher or distributor number" ))
                .addSubField( new SubField( "b", false, "Source" ))
                .addSubField( new SubField( "q", false, "Qualifying information" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "030", new DataRecord( "030", "CODEN Designation ")
                .addSubField( new SubField( "a", false, "CODEN" ))
                .addSubField( new SubField( "z", false, "Canceled/invalid CODEN" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "031", new DataRecord( "031", "Musical Incipits Information ")
                .addSubField( new SubField( "a", false, "Number of work" ))
                .addSubField( new SubField( "b", false, "Number of movement" ))
                .addSubField( new SubField( "c", false, "Number of excerpt" ))
                .addSubField( new SubField( "d", false, "Caption or heading" ))
                .addSubField( new SubField( "e", false, "Role" ))
                .addSubField( new SubField( "g", false, "Clef" ))
                .addSubField( new SubField( "m", false, "Voice/instrument" ))
                .addSubField( new SubField( "n", false, "Key signature" ))
                .addSubField( new SubField( "o", false, "Time signature" ))
                .addSubField( new SubField( "p", false, "Musical notation" ))
                .addSubField( new SubField( "q", false, "General note" ))
                .addSubField( new SubField( "r", false, "Key or mode" ))
                .addSubField( new SubField( "s", false, "Coded validity note" ))
                .addSubField( new SubField( "t", false, "Text incipit" ))
                .addSubField( new SubField( "u", false, "Uniform Resource Identifier" ))
                .addSubField( new SubField( "y", false, "Link text" ))
                .addSubField( new SubField( "z", false, "Public note" ))
                .addSubField( new SubField( "2", false, "System code" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "032", new DataRecord( "032", "Postal Registration Number ")         .addSubField( new SubField( "a", false, "Postal registration number" ))
                .addSubField( new SubField( "b", false, "Source agency assigning number" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "033", new DataRecord( "033", "Date/Time and Place of an Event ")
                .addSubField( new SubField( "a", false, "Formatted date/time" ))
                .addSubField( new SubField( "b", false, "Geographic classification area code" ))
                .addSubField( new SubField( "c", false, "Geographic classification subarea code" ))
                .addSubField( new SubField( "p", false, "Place of event" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source of term" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "034", new DataRecord( "034", "Coded Cartographic Mathematical Data ")
                .addSubField( new SubField( "a", false, "Category of scale" ))
                .addSubField( new SubField( "b", false, "Constant ratio linear horizontal scale" ))
                .addSubField( new SubField( "c", false, "Constant ratio linear vertical scale" ))
                .addSubField( new SubField( "d", false, "Coordinates - westernmost longitude" ))
                .addSubField( new SubField( "e", false, "Coordinates - easternmost longitude" ))
                .addSubField( new SubField( "f", false, "Coordinates - northernmost latitude" ))
                .addSubField( new SubField( "g", false, "Coordinates - southernmost latitude" ))
                .addSubField( new SubField( "h", false, "Angular scale" ))
                .addSubField( new SubField( "j", false, "Declination - northern limit" ))
                .addSubField( new SubField( "k", false, "Declination - southern limit" ))
                .addSubField( new SubField( "m", false, "Right ascension - eastern limit" ))
                .addSubField( new SubField( "n", false, "Right ascension - western limit" ))
                .addSubField( new SubField( "p", false, "Equinox" ))
                .addSubField( new SubField( "r", false, "Distance from earth" ))
                .addSubField( new SubField( "s", false, "G-ring latitude" ))
                .addSubField( new SubField( "t", false, "G-ring longitude" ))
                .addSubField( new SubField( "x", false, "Beginning date" ))
                .addSubField( new SubField( "y", false, "Ending date" ))
                .addSubField( new SubField( "z", false, "Name of extraterrestrial body" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "035", new DataRecord( "035", "System Control Number ")
                .addSubField( new SubField( "a", false, "System control number" ))
                .addSubField( new SubField( "z", false, "Canceled/invalid control number" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "036", new DataRecord( "036", "Original Study Number for Computer Data Files ")
                .addSubField( new SubField( "a", false, "Original study number" ))
                .addSubField( new SubField( "b", false, "Source agency assigning number" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "037", new DataRecord( "037", "Source of Acquisition ")
                .addSubField( new SubField( "a", false, "Stock number" ))
                .addSubField( new SubField( "b", false, "Source of stock number/acquisition" ))
                .addSubField( new SubField( "c", false, "Terms of availability" ))
                .addSubField( new SubField( "f", false, "Form of issue" ))
                .addSubField( new SubField( "g", false, "Additional format characteristics" ))
                .addSubField( new SubField( "n", false, "Note" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "5", false, "Institution to which field applies" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "038", new DataRecord( "038", "Record Content Licensor ")
                .addSubField( new SubField( "a", false, "Record content licensor" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "040", new DataRecord( "040", "Cataloging Source ")
                .addSubField( new SubField( "a", false, "Original cataloging agency" ))
                .addSubField( new SubField( "b", false, "Language of cataloging" ))
                .addSubField( new SubField( "c", false, "Transcribing agency" ))
                .addSubField( new SubField( "d", false, "Modifying agency" ))
                .addSubField( new SubField( "e", false, "Description conventions" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "041", new DataRecord( "041", "Language Code ")
                .addSubField( new SubField( "a", false, "Language code of text/sound track or separate title" ))
                .addSubField( new SubField( "b", false, "Language code of summary or abstract" ))
                .addSubField( new SubField( "d", false, "Language code of sung or spoken text" ))
                .addSubField( new SubField( "e", false, "Language code of librettos" ))
                .addSubField( new SubField( "f", false, "Language code of table of contents" ))
                .addSubField( new SubField( "g", false, "Language code of accompanying material other than librettos and transcripts" ))
                .addSubField( new SubField( "h", false, "Language code of original" ))
                .addSubField( new SubField( "i", false, "Language code of intertitles" ))
                .addSubField( new SubField( "j", false, "Language code of subtitles" ))
                .addSubField( new SubField( "k", false, "Language code of intermediate translations" ))
                .addSubField( new SubField( "m", false, "Language code of original accompanying materials other than librettos" ))
                .addSubField( new SubField( "n", false, "Language code of original libretto" ))
                .addSubField( new SubField( "p", false, "Language code of captions" ))
                .addSubField( new SubField( "q", false, "Language code of accessible audio" ))
                .addSubField( new SubField( "r", false, "Language code of accessible visual language (non-textual)" ))
                .addSubField( new SubField( "t", false, "Language code of accompanying transcripts for audiovisual materials" ))
                .addSubField( new SubField( "2", false, "Source of code" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "042", new DataRecord( "042", "Authentication Code ")
                .addSubField( new SubField( "a", false, "Authentication code" )));
        records.put( "043", new DataRecord( "043", "Geographic Area Code ")
                .addSubField( new SubField( "a", false, "Geographic area code" ))
                .addSubField( new SubField( "b", false, "Local GAC code" ))
                .addSubField( new SubField( "c", false, "ISO code" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source of local code" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "044", new DataRecord( "044", "Country of Publishing/Producing Entity Code ")
                .addSubField( new SubField( "a", false, "MARC country code" ))
                .addSubField( new SubField( "b", false, "Local subentity code" ))
                .addSubField( new SubField( "c", false, "ISO country code" ))
                .addSubField( new SubField( "2", false, "Source of local subentity code" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "045", new DataRecord( "045", "Time Period of Content ")
                .addSubField( new SubField( "a", false, "Time period code" ))
                .addSubField( new SubField( "b", false, "Formatted 9999 B.C. through C.E. time period" ))
                .addSubField( new SubField( "c", false, "Formatted pre-9999 B.C. time period" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "046", new DataRecord( "046", "Special Coded Dates ")
                .addSubField( new SubField( "a", false, "Type of date code" ))
                .addSubField( new SubField( "b", false, "Date 1, B.C.E. date" ))
                .addSubField( new SubField( "c", false, "Date 1, C.E. date" ))
                .addSubField( new SubField( "d", false, "Date 2, B.C.E. date" ))
                .addSubField( new SubField( "e", false, "Date 2, C.E. date" ))
                .addSubField( new SubField( "j", false, "Date resource modified" ))
                .addSubField( new SubField( "k", false, "Beginning or single date created" ))
                .addSubField( new SubField( "l", false, "Ending date created" ))
                .addSubField( new SubField( "m", false, "Beginning of date valid" ))
                .addSubField( new SubField( "n", false, "End of date valid" ))
                .addSubField( new SubField( "o", false, "Single or starting date for aggregated content" ))
                .addSubField( new SubField( "p", false, "Ending date for aggregated content" ))
                .addSubField( new SubField( "x", false, "Nonpublic note" ))
                .addSubField( new SubField( "z", false, "Public note" ))
                .addSubField( new SubField( "2", false, "Source of date" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "047", new DataRecord( "047", "Form of Musical Composition Code ")
                .addSubField( new SubField( "a", false, "Form of musical composition code" ))
                .addSubField( new SubField( "2", false, "Source of code" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "048", new DataRecord( "048", "Number of Musical Instruments or Voices Codes ")
                .addSubField( new SubField( "a", false, "Performer or ensemble" ))
                .addSubField( new SubField( "b", false, "Soloist" ))
                .addSubField( new SubField( "2", false, "Source of code" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "050", new DataRecord( "050", "Library of Congress Call Number ")
                .addSubField( new SubField( "a", false, "Classification number" ))
                .addSubField( new SubField( "b", false, "Item number" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "051", new DataRecord( "051", "Library of Congress Copy, Issue, Offprint Statement ")
                .addSubField( new SubField( "a", false, "Classification number" ))
                .addSubField( new SubField( "b", false, "Item number" ))
                .addSubField( new SubField( "c", false, "Copy information" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "052", new DataRecord( "052", "Geographic Classification ")
                .addSubField( new SubField( "a", false, "Geographic classification area code" ))
                .addSubField( new SubField( "b", false, "Geographic classification subarea code" ))
                .addSubField( new SubField( "d", false, "Populated place name" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Code source" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "055", new DataRecord( "055", "Classification Numbers Assigned in Canada ")
                .addSubField( new SubField( "a", false, "Classification number" ))
                .addSubField( new SubField( "b", false, "Item number" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source of call/class number" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "060", new DataRecord( "060", "National Library of Medicine Call Number ")
                .addSubField( new SubField( "a", false, "Classification number" ))
                .addSubField( new SubField( "b", false, "Item number" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "061", new DataRecord( "061", "National Library of Medicine Copy Statement ")
                .addSubField( new SubField( "a", false, "Classification number" ))
                .addSubField( new SubField( "b", false, "Item number" ))
                .addSubField( new SubField( "c", false, "Copy information" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "066", new DataRecord( "066", "Character Sets Present ")
                .addSubField( new SubField( "a", false, "Primary G0 character set" ))
                .addSubField( new SubField( "b", false, "Primary G1 character set" ))
                .addSubField( new SubField( "c", false, "Alternate G0 or G1 character set" )));
        records.put( "070", new DataRecord( "070", "National Agricultural Library Call Number ")
                .addSubField( new SubField( "a", false, "Classification number" ))
                .addSubField( new SubField( "b", false, "Item number" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "071", new DataRecord( "071", "National Agricultural Library Copy Statement ")
                .addSubField( new SubField( "a", false, "Classification number" ))
                .addSubField( new SubField( "b", false, "Item number" ))
                .addSubField( new SubField( "c", false, "Copy information" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "072", new DataRecord( "072", "Subject Category Code ")
                .addSubField( new SubField( "a", false, "Subject category code" ))
                .addSubField( new SubField( "x", false, "Subject category code subdivision" ))
                .addSubField( new SubField( "2", false, "Source" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "074", new DataRecord( "074", "GPO Item Number ")
                .addSubField( new SubField( "a", false, "GPO item number" ))
                .addSubField( new SubField( "z", false, "Canceled/invalid GPO item number" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "080", new DataRecord( "080", "Universal Decimal Classification Number ")
                .addSubField( new SubField( "a", false, "Universal Decimal Classification number" ))
                .addSubField( new SubField( "b", false, "Item number" ))
                .addSubField( new SubField( "x", false, "Common auxiliary subdivision" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Edition identifier" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "082", new DataRecord( "082", "Dewey Decimal Classification Number ")
                .addSubField( new SubField( "a", false, "Classification number" ))
                .addSubField( new SubField( "b", false, "Item number" ))
                .addSubField( new SubField( "m", false, "Standard or optional designation" ))
                .addSubField( new SubField( "q", false, "Assigning agency" ))
                .addSubField( new SubField( "2", false, "Edition information" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "083", new DataRecord( "083", "Additional Dewey Decimal Classification Number ")
                .addSubField( new SubField( "a", false, "Classification number" ))
                .addSubField( new SubField( "c", false, "Classification number--Ending number of span" ))
                .addSubField( new SubField( "m", false, "Standard or optional designation" ))
                .addSubField( new SubField( "q", false, "Assigning agency" ))
                .addSubField( new SubField( "y", false, "Table sequence number for internal subarrangement or add table" ))
                .addSubField( new SubField( "z", false, "Table identification" ))
                .addSubField( new SubField( "2", false, "Edition information" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "084", new DataRecord( "084", "Other Classification Number ")
                .addSubField( new SubField( "a", false, "Classification number" ))
                .addSubField( new SubField( "b", false, "Item number" ))
                .addSubField( new SubField( "q", false, "Assigning agency" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Number source" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "085", new DataRecord( "085", "Synthesized Classification Number Components ")
                .addSubField( new SubField( "a", false, "Number where instructions are found-single number or beginning number of span" ))
                .addSubField( new SubField( "b", false, "Base number" ))
                .addSubField( new SubField( "c", false, "Classification number-ending number of span" ))
                .addSubField( new SubField( "f", false, "Facet designator" ))
                .addSubField( new SubField( "r", false, "Root number" ))
                .addSubField( new SubField( "s", false, "Digits added from classification number in schedule or external table" ))
                .addSubField( new SubField( "t", false, "Digits added from internal subarrangement or add table" ))
                .addSubField( new SubField( "u", false, "Number being analyzed" ))
                .addSubField( new SubField( "v", false, "Number in internal subarrangement or add table where instructions are found" ))
                .addSubField( new SubField( "w", false, "Table identification-Internal subarrangement or add table" ))
                .addSubField( new SubField( "y", false, "Table sequence number for internal subarrangement or add table" ))
                .addSubField( new SubField( "z", false, "Table identification" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "086", new DataRecord( "086", "Government Document Classification Number ")
                .addSubField( new SubField( "a", false, "Classification number" ))
                .addSubField( new SubField( "z", false, "Canceled/invalid classification number" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Number source" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "088", new DataRecord( "088", "Report Number ")
                .addSubField( new SubField( "a", false, "Report number" ))
                .addSubField( new SubField( "z", false, "Canceled/invalid report number" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "090", new DataRecord( "090", "Local Call Numbers"));
        records.put( "091", new DataRecord( "091", "Local Call Numbers"));
        records.put( "092", new DataRecord( "092", "Local Call Numbers"));
        records.put( "093", new DataRecord( "093", "Local Call Numbers"));
        records.put( "094", new DataRecord( "094", "Local Call Numbers"));
        records.put( "095", new DataRecord( "095", "Local Call Numbers"));
        records.put( "096", new DataRecord( "096", "Local Call Numbers"));
        records.put( "097", new DataRecord( "097", "Local Call Numbers"));
        records.put( "098", new DataRecord( "098", "Local Call Numbers"));
        records.put( "099", new DataRecord( "099", "Local Call Numbers"));
        records.put( "100", new DataRecord( "100", "Main Entry - Personal Name ")
                .addSubField( new SubField( "a", false, "Personal name" ))
                .addSubField( new SubField( "b", false, "Numeration" ))
                .addSubField( new SubField( "c", false, "Titles and words associated with a name" ))
                .addSubField( new SubField( "d", false, "Dates associated with a name" ))
                .addSubField( new SubField( "e", false, "Relator term" ))
                .addSubField( new SubField( "f", false, "Date of a work" ))
                .addSubField( new SubField( "g", false, "Miscellaneous information" ))
                .addSubField( new SubField( "j", false, "Attribution qualifier" ))
                .addSubField( new SubField( "k", false, "Form subheading" ))
                .addSubField( new SubField( "l", false, "Language of a work" ))
                .addSubField( new SubField( "n", false, "Number of part/section of a work" ))
                .addSubField( new SubField( "p", false, "Name of part/section of a work" ))
                .addSubField( new SubField( "q", false, "Fuller form of name" ))
                .addSubField( new SubField( "t", false, "Title of a work" ))
                .addSubField( new SubField( "u", false, "Affiliation" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source of heading or term" ))
                .addSubField( new SubField( "4", false, "Relationship" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "110", new DataRecord( "110", "Main Entry - Corporate Name ")
                .addSubField( new SubField( "a", false, "Corporate name or jurisdiction name as entry element" ))
                .addSubField( new SubField( "b", false, "Subordinate unit" ))
                .addSubField( new SubField( "c", false, "Location of meeting" ))
                .addSubField( new SubField( "d", false, "Date of meeting or treaty signing" ))
                .addSubField( new SubField( "e", false, "Relator term" ))
                .addSubField( new SubField( "f", false, "Date of a work" ))
                .addSubField( new SubField( "g", false, "Miscellaneous information" ))
                .addSubField( new SubField( "k", false, "Form subheading" ))
                .addSubField( new SubField( "l", false, "Language of a work" ))
                .addSubField( new SubField( "n", false, "Number of part/section/meeting" ))
                .addSubField( new SubField( "p", false, "Name of part/section of a work" ))
                .addSubField( new SubField( "t", false, "Title of a work" ))
                .addSubField( new SubField( "u", false, "Affiliation" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source of heading or term" ))
                .addSubField( new SubField( "4", false, "Relationship" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "111", new DataRecord( "111", "Main Entry - Meeting Name ")
                .addSubField( new SubField( "a", false, "Meeting name or jurisdiction name as entry element" ))
                .addSubField( new SubField( "c", false, "Location of meeting" ))
                .addSubField( new SubField( "d", false, "Date of meeting or treaty signing" ))
                .addSubField( new SubField( "e", false, "Subordinate unit" ))
                .addSubField( new SubField( "f", false, "Date of a work" ))
                .addSubField( new SubField( "g", false, "Miscellaneous information" ))
                .addSubField( new SubField( "j", false, "Relator term" ))
                .addSubField( new SubField( "k", false, "Form subheading" ))
                .addSubField( new SubField( "l", false, "Language of a work" ))
                .addSubField( new SubField( "n", false, "Number of part/section/meeting" ))
                .addSubField( new SubField( "p", false, "Name of part/section of a work" ))
                .addSubField( new SubField( "q", false, "Name of meeting following jurisdiction name entry element" ))
                .addSubField( new SubField( "t", false, "Title of a work" ))
                .addSubField( new SubField( "u", false, "Affiliation" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source of heading or term" ))
                .addSubField( new SubField( "4", false, "Relationship" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "130", new DataRecord( "130", "Main Entry - Uniform Title ")
                .addSubField( new SubField( "a", false, "Uniform title" ))
                .addSubField( new SubField( "d", false, "Date of treaty signing" ))
                .addSubField( new SubField( "f", false, "Date of a work" ))
                .addSubField( new SubField( "g", false, "Miscellaneous information" ))
                .addSubField( new SubField( "h", false, "Medium" ))
                .addSubField( new SubField( "k", false, "Form subheading" ))
                .addSubField( new SubField( "l", false, "Language of a work" ))
                .addSubField( new SubField( "m", false, "Medium of performance for music" ))
                .addSubField( new SubField( "n", false, "Number of part/section of a work" ))
                .addSubField( new SubField( "o", false, "Arranged statement for music" ))
                .addSubField( new SubField( "p", false, "Name of part/section of a work" ))
                .addSubField( new SubField( "r", false, "Key for music" ))
                .addSubField( new SubField( "s", false, "Version" ))
                .addSubField( new SubField( "t", false, "Title of a work" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source of heading or term" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "210", new DataRecord( "210", "Abbreviated Title ")
                .addSubField( new SubField( "a", false, "Abbreviated title" ))
                .addSubField( new SubField( "b", false, "Qualifying information" ))
                .addSubField( new SubField( "2", false, "Source" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "222", new DataRecord( "222", "Key Title ")
                .addSubField( new SubField( "a", false, "Key title" ))
                .addSubField( new SubField( "b", false, "Qualifying information"))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "240", new DataRecord( "240", "Uniform Title ")
                .addSubField( new SubField( "a", false, "Uniform title" ))
                .addSubField( new SubField( "d", false, "Date of treaty signing" ))
                .addSubField( new SubField( "f", false, "Date of a work" ))
                .addSubField( new SubField( "g", false, "Miscellaneous information" ))
                .addSubField( new SubField( "h", false, "Medium" ))
                .addSubField( new SubField( "k", false, "Form subheading" ))
                .addSubField( new SubField( "l", false, "Language of a work" ))
                .addSubField( new SubField( "m", false, "Medium of performance for music" ))
                .addSubField( new SubField( "n", false, "Number of part/section of a work" ))
                .addSubField( new SubField( "o", false, "Arranged statement for music" ))
                .addSubField( new SubField( "p", false, "Name of part/section of a work" ))
                .addSubField( new SubField( "r", false, "Key for music" ))
                .addSubField( new SubField( "s", false, "Version" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source of heading or term" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "242", new DataRecord( "242", "Translation of Title by Cataloging Agency ")
                .addSubField( new SubField( "a", false, "Title" ))
                .addSubField( new SubField( "b", false, "Remainder of title" ))
                .addSubField( new SubField( "c", false, "Statement of responsibility, etc." ))
                .addSubField( new SubField( "h", false, "Medium" ))
                .addSubField( new SubField( "n", false, "Number of part/section of a work" ))
                .addSubField( new SubField( "p", false, "Name of part/section of a work" ))
                .addSubField( new SubField( "y", false, "Language code of translated title" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "243", new DataRecord( "243", "Collective Uniform Title ")
                .addSubField( new SubField( "a", false, "Uniform title" ))
                .addSubField( new SubField( "d", false, "Date of treaty signing" ))
                .addSubField( new SubField( "f", false, "Date of a work" ))
                .addSubField( new SubField( "g", false, "Miscellaneous information" ))
                .addSubField( new SubField( "h", false, "Medium" ))
                .addSubField( new SubField( "k", false, "Form subheading" ))
                .addSubField( new SubField( "l", false, "Language of a work" ))
                .addSubField( new SubField( "m", false, "Medium of performance for music" ))
                .addSubField( new SubField( "n", false, "Number of part/section of a work" ))
                .addSubField( new SubField( "o", false, "Arranged statement for music" ))
                .addSubField( new SubField( "p", false, "Name of part/section of a work" ))
                .addSubField( new SubField( "r", false, "Key for music" ))
                .addSubField( new SubField( "s", false, "Version" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "245", new DataRecord( "245", "Title Statement ")
                .addSubField( new SubField( "a", false, "Title" ))
                .addSubField( new SubField( "b", false, "Remainder of title" ))
                .addSubField( new SubField( "c", false, "Statement of responsibility, etc." ))
                .addSubField( new SubField( "f", false, "Inclusive dates" ))
                .addSubField( new SubField( "g", false, "Bulk dates" ))
                .addSubField( new SubField( "h", false, "Medium" ))
                .addSubField( new SubField( "k", false, "Form" ))
                .addSubField( new SubField( "n", false, "Number of part/section of a work" ))
                .addSubField( new SubField( "p", false, "Name of part/section of a work" ))
                .addSubField( new SubField( "s", false, "Version" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "246", new DataRecord( "246", "Varying Form of Title ")
                .addSubField( new SubField( "a", false, "Title proper/short title" ))
                .addSubField( new SubField( "b", false, "Remainder of title" ))
                .addSubField( new SubField( "f", false, "Date or sequential designation" ))
                .addSubField( new SubField( "g", false, "Miscellaneous information" ))
                .addSubField( new SubField( "h", false, "Medium" ))
                .addSubField( new SubField( "i", false, "Display text" ))
                .addSubField( new SubField( "n", false, "Number of part/section of a work" ))
                .addSubField( new SubField( "p", false, "Name of part/section of a work" ))
                .addSubField( new SubField( "5", false, "Institution to which field applies" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "247", new DataRecord( "247", "Former Title ")
                .addSubField( new SubField( "a", false, "Title" ))
                .addSubField( new SubField( "b", false, "Remainder of title" ))
                .addSubField( new SubField( "f", false, "Date or sequential designation" ))
                .addSubField( new SubField( "g", false, "Miscellaneous information" ))
                .addSubField( new SubField( "h", false, "Medium" ))
                .addSubField( new SubField( "n", false, "Number of part/section of a work" ))
                .addSubField( new SubField( "p", false, "Name of part/section of a work" ))
                .addSubField( new SubField( "x", false, "International Standard Serial Number" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "250", new DataRecord( "250", "Edition Statement ")
                .addSubField( new SubField( "a", false, "Edition statement" ))
                .addSubField( new SubField( "b", false, "Remainder of edition statement" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "251", new DataRecord( "251", "Version Information ")
                .addSubField( new SubField( "a", false, "Version" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "254", new DataRecord( "254", "Musical Presentation Statement ")
                .addSubField( new SubField( "a", false, "Musical presentation statement" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "255", new DataRecord( "255", "Cartographic Mathematical Data ")
                .addSubField( new SubField( "a", false, "Statement of scale" ))
                .addSubField( new SubField( "b", false, "Statement of projection" ))
                .addSubField( new SubField( "c", false, "Statement of coordinates" ))
                .addSubField( new SubField( "d", false, "Statement of zone" ))
                .addSubField( new SubField( "e", false, "Statement of equinox" ))
                .addSubField( new SubField( "f", false, "Outer G-ring coordinate pairs" ))
                .addSubField( new SubField( "g", false, "Exclusion G-ring coordinate pairs" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "256", new DataRecord( "256", "Computer File Characteristics ")
                .addSubField( new SubField( "a", false, "Computer file characteristics" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "257", new DataRecord( "257", "Country of Producing Entity ")
                .addSubField( new SubField( "a", false, "Country of producing entity" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "258", new DataRecord( "258", "Philatelic Issue Data ")
                .addSubField( new SubField( "a", false, "Issuing jurisdiction" ))
                .addSubField( new SubField( "b", false, "Denomination" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "260", new DataRecord( "260", "Publication, Distribution, etc. ")
                .addSubField( new SubField( "a", false, "Place of publication, distribution, etc." ))
                .addSubField( new SubField( "b", false, "Name of publisher, distributor, etc." ))
                .addSubField( new SubField( "c", false, "Date of publication, distribution, etc." ))
                .addSubField( new SubField( "e", false, "Place of manufacture" ))
                .addSubField( new SubField( "f", false, "Manufacturer" ))
                .addSubField( new SubField( "g", false, "Date of manufacture" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number (Imprint)" )));
        records.put( "263", new DataRecord( "263", "Projected Publication Date ")
                .addSubField( new SubField( "a", false, "Projected publication date" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "264", new DataRecord( "264", "Production, Publication, Distribution, Manufacture, and Copyright Notice ")
                .addSubField( new SubField( "a", false, "Place of production, publication, distribution, manufacture" ))
                .addSubField( new SubField( "b", false, "Name of producer, publisher, distributor, manufacturer" ))
                .addSubField( new SubField( "c", false, "Date of production, publication, distribution, manufacture, or copyright notice" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "270", new DataRecord( "270", "Address ")
                .addSubField( new SubField( "a", false, "Address" ))
                .addSubField( new SubField( "b", false, "City" ))
                .addSubField( new SubField( "c", false, "State or province" ))
                .addSubField( new SubField( "d", false, "Country" ))
                .addSubField( new SubField( "e", false, "Postal code" ))
                .addSubField( new SubField( "f", false, "Terms preceding attention name" ))
                .addSubField( new SubField( "g", false, "Attention name" ))
                .addSubField( new SubField( "h", false, "Attention position" ))
                .addSubField( new SubField( "i", false, "Type of address" ))
                .addSubField( new SubField( "j", false, "Specialized telephone number" ))
                .addSubField( new SubField( "k", false, "Telephone number" ))
                .addSubField( new SubField( "l", false, "Fax number" ))
                .addSubField( new SubField( "m", false, "Electronic mail address" ))
                .addSubField( new SubField( "n", false, "TDD or TTY number" ))
                .addSubField( new SubField( "p", false, "Contact person" ))
                .addSubField( new SubField( "q", false, "Title of contact person" ))
                .addSubField( new SubField( "r", false, "Hours" ))
                .addSubField( new SubField( "z", false, "Public note" ))
                .addSubField( new SubField( "4", false, "Relationship" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "300", new DataRecord( "300", "Physical Description "));
        records.put( "306", new DataRecord( "306", "Playing Time "));
        records.put( "307", new DataRecord( "307", "Hours, etc. "));
        records.put( "310", new DataRecord( "310", "Current Publication Frequency "));
        records.put( "321", new DataRecord( "321", "Former Publication Frequency "));
        records.put( "334", new DataRecord( "334", "Mode of Issuance "));
        records.put( "335", new DataRecord( "335", "Extension Plan "));
        records.put( "336", new DataRecord( "336", "Content Type "));
        records.put( "337", new DataRecord( "337", "Media Type "));
        records.put( "338", new DataRecord( "338", "Carrier Type "));
        records.put( "340", new DataRecord( "340", "Physical Medium "));
        records.put( "341", new DataRecord( "341", "Accessibility Content "));
        records.put( "342", new DataRecord( "342", "Geospatial Reference Data "));
        records.put( "343", new DataRecord( "343", "Planar Coordinate Data "));
        records.put( "344", new DataRecord( "344", "Sound Characteristics "));
        records.put( "345", new DataRecord( "345", "Moving Image Characteristics "));
        records.put( "346", new DataRecord( "346", "Video Characteristics "));
        records.put( "347", new DataRecord( "347", "Digital File Characteristics "));
        records.put( "348", new DataRecord( "348", "Notated Music Characteristics "));
        records.put( "351", new DataRecord( "351", "Organization and Arrangement of Materials "));
        records.put( "352", new DataRecord( "352", "Digital Graphic Representation "));
        records.put( "353", new DataRecord( "353", "Supplementary Content Characteristics "));
        records.put( "355", new DataRecord( "355", "Security Classification Control "));
        records.put( "357", new DataRecord( "357", "Originator Dissemination Control "));
        records.put( "361", new DataRecord( "361", "Structured Ownership and Custodial History "));
        records.put( "362", new DataRecord( "362", "Dates of Publication and/or Sequential Designation "));
        records.put( "363", new DataRecord( "363", "Normalized Date and Sequential Designation "));
        records.put( "365", new DataRecord( "365", "Trade Price "));
        records.put( "366", new DataRecord( "366", "Trade Availability Information "));
        records.put( "370", new DataRecord( "370", "Associated Place ")
                .addSubField( new SubField( "c", false, "Associated country" ))
                .addSubField( new SubField( "f", false, "Other associated place" ))
                .addSubField( new SubField( "g", false, "Place of origin of work or expression" ))
                .addSubField( new SubField( "i", false, "Relationship information" ))
                .addSubField( new SubField( "s", false, "Start period" ))
                .addSubField( new SubField( "t", false, "End period" ))
                .addSubField( new SubField( "u", false, "Uniform Resource Identifier" ))
                .addSubField( new SubField( "v", false, "Source of information" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source of term" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "4", false, "Relationship" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "377", new DataRecord( "377", "Associated Language ")
                .addSubField( new SubField( "a", false, "Language code" ))
                .addSubField( new SubField( "l", false, "Language term" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "380", new DataRecord( "380", "Form of Work "));
        records.put( "381", new DataRecord( "381", "Other Distinguishing Characteristics of Work or Expression "));
        records.put( "382", new DataRecord( "382", "Medium of Performance "));
        records.put( "383", new DataRecord( "383", "Numeric Designation of Musical Work "));
        records.put( "384", new DataRecord( "384", "Key "));
        records.put( "385", new DataRecord( "385", "Audience Characteristics "));
        records.put( "386", new DataRecord( "386", "Creator/Contributor Characteristics "));
        records.put( "387", new DataRecord( "387", "Representative Expression Characteristics "));
        records.put( "388", new DataRecord( "388", "Time Period of Creation "));
        records.put( "400", new DataRecord( "400", "ISNI alternative name")
                .addSubField( new SubField( "a", false, "full name" ))
                .addSubField( new SubField( "3", false, "name use" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "500", new DataRecord( "500", "General Note "));
        records.put( "501", new DataRecord( "501", "With Note "));
        records.put( "502", new DataRecord( "502", "Dissertation Note "));
        records.put( "504", new DataRecord( "504", "Bibliography, etc. Note "));
        records.put( "505", new DataRecord( "505", "Formatted Contents Note "));
        records.put( "506", new DataRecord( "506", "Restrictions on Access Note "));
        records.put( "507", new DataRecord( "507", "Scale Note for Visual Materials "));
        records.put( "508", new DataRecord( "508", "Creation/Production Credits Note "));
        records.put( "510", new DataRecord( "510", "Citation/References Note "));
        records.put( "511", new DataRecord( "511", "Participant or Performer Note "));
        records.put( "513", new DataRecord( "513", "Type of Report and Period Covered Note "));
        records.put( "514", new DataRecord( "514", "Data Quality Note "));
        records.put( "515", new DataRecord( "515", "Numbering Peculiarities Note "));
        records.put( "516", new DataRecord( "516", "Type of Computer File or Data Note "));
        records.put( "518", new DataRecord( "518", "Date/Time and Place of an Event Note "));
        records.put( "520", new DataRecord( "520", "Summary, etc. "));
        records.put( "521", new DataRecord( "521", "Target Audience Note "));
        records.put( "522", new DataRecord( "522", "Geographic Coverage Note "));
        records.put( "524", new DataRecord( "524", "Preferred Citation of Described Materials Note "));
        records.put( "525", new DataRecord( "525", "Supplement Note "));
        records.put( "526", new DataRecord( "526", "Study Program Information Note "));
        records.put( "530", new DataRecord( "530", "Additional Physical Form available Note "));
        records.put( "532", new DataRecord( "532", "Accessibility Note "));
        records.put( "533", new DataRecord( "533", "Reproduction Note "));
        records.put( "534", new DataRecord( "534", "Original Version Note "));
        records.put( "535", new DataRecord( "535", "Location of Originals/Duplicates Note "));
        records.put( "536", new DataRecord( "536", "Funding Information Note "));
        records.put( "538", new DataRecord( "538", "System Details Note "));
        records.put( "540", new DataRecord( "540", "Terms Governing Use and Reproduction Note "));
        records.put( "541", new DataRecord( "541", "Immediate Source of Acquisition Note "));
        records.put( "542", new DataRecord( "542", "Information Relating to Copyright Status "));
        records.put( "544", new DataRecord( "544", "Location of Other Archival Materials Note "));
        records.put( "545", new DataRecord( "545", "Biographical or Historical Data "));
        records.put( "546", new DataRecord( "546", "Language Note "));
        records.put( "547", new DataRecord( "547", "Former Title Complexity Note "));
        records.put( "550", new DataRecord( "550", "Issuing Body Note "));
        records.put( "552", new DataRecord( "552", "Entity and Attribute Information Note "));
        records.put( "555", new DataRecord( "555", "Cumulative Index/Finding Aids Note "));
        records.put( "556", new DataRecord( "556", "Information About Documentation Note "));
        records.put( "561", new DataRecord( "561", "Ownership and Custodial History "));
        records.put( "562", new DataRecord( "562", "Copy and Version Identification Note "));
        records.put( "563", new DataRecord( "563", "Binding Information "));
        records.put( "565", new DataRecord( "565", "Case File Characteristics Note "));
        records.put( "567", new DataRecord( "567", "Methodology Note "));
        records.put( "580", new DataRecord( "580", "Linking Entry Complexity Note "));
        records.put( "581", new DataRecord( "581", "Publications About Described Materials Note "));
        records.put( "583", new DataRecord( "583", "Action Note "));
        records.put( "584", new DataRecord( "584", "Accumulation and Frequency of Use Note "));
        records.put( "585", new DataRecord( "585", "Exhibitions Note "));
        records.put( "586", new DataRecord( "586", "Awards Note "));
        records.put( "588", new DataRecord( "588", "Source of Description, Etc. Note "));
        records.put( "590", new DataRecord( "590", "Local Notes"));
        records.put( "591", new DataRecord( "591", "Local Notes"));
        records.put( "592", new DataRecord( "592", "Local Notes"));
        records.put( "593", new DataRecord( "593", "Local Notes"));
        records.put( "594", new DataRecord( "594", "Local Notes"));
        records.put( "595", new DataRecord( "595", "Local Notes"));
        records.put( "596", new DataRecord( "596", "Local Notes"));
        records.put( "597", new DataRecord( "597", "Local Notes"));
        records.put( "598", new DataRecord( "598", "Local Notes"));
        records.put( "599", new DataRecord( "599", "Local Notes"));
        records.put( "600", new DataRecord( "600", "Subject Added Entry - Personal Name "));
        records.put( "610", new DataRecord( "610", "Subject Added Entry - Corporate Name "));
        records.put( "611", new DataRecord( "611", "Subject Added Entry - Meeting Name "));
        records.put( "630", new DataRecord( "630", "Subject Added Entry - Uniform Title "));
        records.put( "647", new DataRecord( "647", "Subject Added Entry - Named Event "));
        records.put( "648", new DataRecord( "648", "Subject Added Entry - Chronological Term "));
        records.put( "650", new DataRecord( "650", "Subject Added Entry - Topical Term "));
        records.put( "651", new DataRecord( "651", "Subject Added Entry - Geographic Name "));
        records.put( "653", new DataRecord( "653", "Index Term - Uncontrolled "));
        records.put( "654", new DataRecord( "654", "Subject Added Entry - Faceted Topical Terms "));
        records.put( "655", new DataRecord( "655", "Index Term - Genre/Form "));
        records.put( "656", new DataRecord( "656", "Index Term - Occupation "));
        records.put( "657", new DataRecord( "657", "Index Term - Function "));
        records.put( "658", new DataRecord( "658", "Index Term - Curriculum Objective "));
        records.put( "662", new DataRecord( "662", "Subject Added Entry - Hierarchical Place Name "));
        records.put( "671", new DataRecord( "671", "ISNI title URLs")
                .addSubField( new SubField( "g", false, "type" ))
                .addSubField( new SubField( "u", false, "url" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "688", new DataRecord( "688", "Subject Added Entry - Type of Entity Unspecified "));
        records.put( "690", new DataRecord( "690", "Local Subject Access Fields "));
        records.put( "691", new DataRecord( "691", "Local Subject Access Fields "));
        records.put( "692", new DataRecord( "692", "Local Subject Access Fields "));
        records.put( "693", new DataRecord( "693", "Local Subject Access Fields "));
        records.put( "694", new DataRecord( "694", "Local Subject Access Fields "));
        records.put( "695", new DataRecord( "695", "Local Subject Access Fields "));
        records.put( "696", new DataRecord( "696", "Local Subject Access Fields "));
        records.put( "697", new DataRecord( "697", "Local Subject Access Fields "));
        records.put( "698", new DataRecord( "698", "Local Subject Access Fields "));
        records.put( "699", new DataRecord( "699", "Local Subject Access Fields "));
        records.put( "700", new DataRecord( "700", "Added Entry - Personal Name ")
                .addSubField( new SubField( "a", false, "Personal name" ))
                .addSubField( new SubField( "b", false, "Numeration" ))
                .addSubField( new SubField( "c", false, "Titles and other words associated with a name" ))
                .addSubField( new SubField( "d", false, "Dates associated with a name" ))
                .addSubField( new SubField( "e", false, "Relator term" ))
                .addSubField( new SubField( "f", false, "Date of a work" ))
                .addSubField( new SubField( "g", false, "Miscellaneous information" ))
                .addSubField( new SubField( "h", false, "Medium" ))
                .addSubField( new SubField( "i", false, "Relationship information" ))
                .addSubField( new SubField( "j", false, "Attribution qualifier" ))
                .addSubField( new SubField( "k", false, "Form subheading" ))
                .addSubField( new SubField( "l", false, "Language of a work" ))
                .addSubField( new SubField( "m", false, "Medium of performance for music" ))
                .addSubField( new SubField( "n", false, "Number of part/section of a work" ))
                .addSubField( new SubField( "o", false, "Arranged statement for music" ))
                .addSubField( new SubField( "p", false, "Name of part/section of a work" ))
                .addSubField( new SubField( "q", false, "Fuller form of name" ))
                .addSubField( new SubField( "r", false, "Key for music" ))
                .addSubField( new SubField( "s", false, "Version" ))
                .addSubField( new SubField( "t", false, "Title of a work" ))
                .addSubField( new SubField( "u", false, "Affiliation" ))
                .addSubField( new SubField( "x", false, "International Standard Serial Number" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source of heading or term" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "4", false, "Relationship" ))
                .addSubField( new SubField( "5", false, "Institution to which field applies" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "710", new DataRecord( "710", "Added Entry - Corporate Name ")        .addSubField( new SubField( "a", false, "Corporate name or jurisdiction name as entry element" ))
                .addSubField( new SubField( "b", false, "Subordinate unit" ))
                .addSubField( new SubField( "c", false, "Location of meeting" ))
                .addSubField( new SubField( "d", false, "Date of meeting or treaty signing" ))
                .addSubField( new SubField( "e", false, "Relator term" ))
                .addSubField( new SubField( "f", false, "Date of a work" ))
                .addSubField( new SubField( "g", false, "Miscellaneous information" ))
                .addSubField( new SubField( "h", false, "Medium" ))
                .addSubField( new SubField( "i", false, "Relationship information" ))
                .addSubField( new SubField( "k", false, "Form subheading" ))
                .addSubField( new SubField( "l", false, "Language of a work" ))
                .addSubField( new SubField( "m", false, "Medium of performance for music" ))
                .addSubField( new SubField( "n", false, "Number of part/section/meeting" ))
                .addSubField( new SubField( "o", false, "Arranged statement for music" ))
                .addSubField( new SubField( "p", false, "Name of part/section of a work" ))
                .addSubField( new SubField( "r", false, "Key for music" ))
                .addSubField( new SubField( "s", false, "Version" ))
                .addSubField( new SubField( "t", false, "Title of a work" ))
                .addSubField( new SubField( "u", false, "Affiliation" ))
                .addSubField( new SubField( "x", false, "International Standard Serial Number" ))
                .addSubField( new SubField( "0", false, "Authority record control number or standard number" ))
                .addSubField( new SubField( "1", false, "Real World Object URI" ))
                .addSubField( new SubField( "2", false, "Source of heading or term" ))
                .addSubField( new SubField( "3", false, "Materials specified" ))
                .addSubField( new SubField( "4", false, "Relationship" ))
                .addSubField( new SubField( "5", false, "Institution to which field applies" ))
                .addSubField( new SubField( "6", false, "Linkage" ))
                .addSubField( new SubField( "7", false, "Data provenance" ))
                .addSubField( new SubField( "8", false, "Field link and sequence number" )));
        records.put( "711", new DataRecord( "711", "Added Entry - Meeting Name "));
        records.put( "720", new DataRecord( "720", "Added Entry - Uncontrolled Name "));
        records.put( "730", new DataRecord( "730", "Added Entry - Uniform Title "));
        records.put( "740", new DataRecord( "740", "Added Entry - Uncontrolled Related/Analytical Title "));
        records.put( "751", new DataRecord( "751", "Added Entry - Geographic Name "));
        records.put( "752", new DataRecord( "752", "Added Entry - Hierarchical Place Name "));
        records.put( "753", new DataRecord( "753", "System Details Access to Computer Files "));
        records.put( "754", new DataRecord( "754", "Added Entry - Taxonomic Identification "));
        records.put( "758", new DataRecord( "758", "Resource Identifier "));
        records.put( "760", new DataRecord( "760", "Linking Entry Fields - General Information"));
        records.put( "761", new DataRecord( "761", "Linking Entry Fields - General Information"));
        records.put( "762", new DataRecord( "762", "Linking Entry Fields - General Information"));
        records.put( "763", new DataRecord( "763", "Linking Entry Fields - General Information"));
        records.put( "764", new DataRecord( "764", "Linking Entry Fields - General Information"));
        records.put( "765", new DataRecord( "765", "Linking Entry Fields - General Information"));
        records.put( "766", new DataRecord( "766", "Linking Entry Fields - General Information"));
        records.put( "767", new DataRecord( "767", "Linking Entry Fields - General Information"));
        records.put( "768", new DataRecord( "768", "Linking Entry Fields - General Information"));
        records.put( "769", new DataRecord( "769", "Linking Entry Fields - General Information"));
        records.put( "770", new DataRecord( "770", "Linking Entry Fields - General Information"));
        records.put( "771", new DataRecord( "771", "Linking Entry Fields - General Information"));
        records.put( "772", new DataRecord( "772", "Linking Entry Fields - General Information"));
        records.put( "773", new DataRecord( "773", "Linking Entry Fields - General Information"));
        records.put( "774", new DataRecord( "774", "Linking Entry Fields - General Information"));
        records.put( "775", new DataRecord( "775", "Linking Entry Fields - General Information"));
        records.put( "776", new DataRecord( "776", "Linking Entry Fields - General Information"));
        records.put( "777", new DataRecord( "777", "Linking Entry Fields - General Information"));
        records.put( "778", new DataRecord( "778", "Linking Entry Fields - General Information"));
        records.put( "779", new DataRecord( "779", "Linking Entry Fields - General Information"));
        records.put( "780", new DataRecord( "780", "Linking Entry Fields - General Information"));
        records.put( "781", new DataRecord( "781", "Linking Entry Fields - General Information"));
        records.put( "782", new DataRecord( "782", "Linking Entry Fields - General Information"));
        records.put( "783", new DataRecord( "783", "Linking Entry Fields - General Information"));
        records.put( "784", new DataRecord( "784", "Linking Entry Fields - General Information"));
        records.put( "785", new DataRecord( "785", "Linking Entry Fields - General Information"));
        records.put( "786", new DataRecord( "786", "Linking Entry Fields - General Information"));
        records.put( "787", new DataRecord( "787", "Linking Entry Fields - General Information"));
        records.put( "788", new DataRecord( "788", "Parallel Description in Another Language of Cataloging "));
        records.put( "800", new DataRecord( "800", "Series Added Entry - Personal Name "));
        records.put( "810", new DataRecord( "810", "Series Added Entry - Corporate Name "));
        records.put( "811", new DataRecord( "811", "Series Added Entry - Meeting Name "));
        records.put( "830", new DataRecord( "830", "Series Added Entry - Uniform Title "));
        records.put( "841", new DataRecord( "841", "Holdings Coded Data Values "));
        records.put( "842", new DataRecord( "842", "Textual Physical Form Designator "));
        records.put( "843", new DataRecord( "843", "Reproduction Note "));
        records.put( "844", new DataRecord( "844", "Name of Unit "));
        records.put( "845", new DataRecord( "845", "Terms Governing Use and Reproduction "));
        records.put( "850", new DataRecord( "850", "Holding Institution "));
        records.put( "852", new DataRecord( "852", "Location "));
        records.put( "853", new DataRecord( "853", "Captions and Pattern - Basic Bibliographic Unit "));
        records.put( "854", new DataRecord( "854", "Captions and Pattern - Supplementary Material "));
        records.put( "855", new DataRecord( "855", "Captions and Pattern - Indexes "));
        records.put( "856", new DataRecord( "856", "Electronic Location and Access "));
        records.put( "857", new DataRecord( "857", "Electronic Archive Location and Access "));
        records.put( "863", new DataRecord( "863", "Enumeration and Chronology - Basic Bibliographic Unit "));
        records.put( "864", new DataRecord( "864", "Enumeration and Chronology - Supplementary Material "));
        records.put( "865", new DataRecord( "865", "Enumeration and Chronology - Indexes "));
        records.put( "866", new DataRecord( "866", "Textual Holdings - Basic Bibliographic Unit "));
        records.put( "867", new DataRecord( "867", "Textual Holdings - Supplementary Material "));
        records.put( "868", new DataRecord( "868", "Textual Holdings - Indexes "));
        records.put( "876", new DataRecord( "876", "Item Information - Basic Bibliographic Unit "));
        records.put( "877", new DataRecord( "877", "Item Information - Supplementary Material "));
        records.put( "878", new DataRecord( "878", "Item Information - Indexes "));
        records.put( "880", new DataRecord( "880", "Alternate Graphic Representation "));
        records.put( "881", new DataRecord( "881", "Manifestation Statements "));
        records.put( "882", new DataRecord( "882", "Replacement Record Information "));
        records.put( "883", new DataRecord( "883", "Metadata Provenance "));
        records.put( "884", new DataRecord( "884", "Description Conversion Information "));
        records.put( "885", new DataRecord( "885", "Matching Information "));
        records.put( "886", new DataRecord( "886", "Foreign MARC Information Field "));
        records.put( "887", new DataRecord( "887", "Non-MARC Information Field "));
        records.put( "901", new DataRecord( "901", "ISNI title ISBN")
                .addSubField( new SubField( "a", false, "ISBN" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "902", new DataRecord( "902", "ISNI title ISSN")
                .addSubField( new SubField( "a", false, "ISSN" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "904", new DataRecord( "904", "ISNI other ID")
                .addSubField( new SubField( "a", false, "title ID" ))
                .addSubField( new SubField( "l", false, "title ID type" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "910", new DataRecord( "910", "ISNI title")
                .addSubField( new SubField( "a", false, "title" ))
                .addSubField( new SubField( "d", false, "subtitle" ))
                .addSubField( new SubField( "h", false, "composer" ))
                .addSubField( new SubField( "w", false, "work code ISWC" ))
                .addSubField( new SubField( "r", false, "recording code ISRC" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "912", new DataRecord( "912", "ISNI controbuted to")
                .addSubField( new SubField( "a", false, "contributed to" ))
                .addSubField( new SubField( "w", false, "work code ISWC" ))
                .addSubField( new SubField( "r", false, "recording code ISRC" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "921", new DataRecord( "921", "ISNI title publisher")
                .addSubField( new SubField( "a", false, "publisher" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "925", new DataRecord( "925", "ISNI title instrument")
                .addSubField( new SubField( "a", false, "instrument" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "941", new DataRecord( "941", "ISNI title creation role")
                .addSubField( new SubField( "a", false, "creation role" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "943", new DataRecord( "943", "ISNI year of publication")
                .addSubField( new SubField("a", false, "year of publication" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "944", new DataRecord( "944", "ISNI title creation class")
                .addSubField( new SubField( "a", false, "creation class" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "950", new DataRecord( "950", "ISNI releated person")
                .addSubField( new SubField( "a", false, "surname" ))
                .addSubField( new SubField( "T", false, "relationshiptype" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "951", new DataRecord( "951", "ISNI affiliated organization")
                .addSubField( new SubField( "a", false, "organization" ))
                .addSubField( new SubField( "T", false, "relationshiptype" ))
                .addSubField( new SubField( "2", false, "source" )));
        records.put( "970", new DataRecord( "970", "ISNI add start/birth and stop/death dates")
                .addSubField( new SubField( "a", false, "start date / birth" ))
                .addSubField( new SubField( "b", false, "end date / death" ))
                .addSubField( new SubField( "2", false, "source" )));

        logger.info("Loaded {} records", records.size());
        logger.info("Records: {}", records.toString());
    }

    public static Marc21Dictionary getInstance() {
        if (instance == null) {
            synchronized (Marc21Dictionary.class) {
                if (instance == null) {
                    instance = new Marc21Dictionary();
                }
            }
        }
        return instance;
    }

    public boolean isControlRecord(String tag) {
        if (records.containsKey(tag)) { return records.get(tag).getType() == Definitions.CONTROL_RECORD; }
        return false;
    }

    public boolean isDataRecord(String tag) {
        if (records.containsKey(tag)) { return records.get(tag).getType() == Definitions.DATA_RECORD; }
        return false;
    }
    public BaseRecord getRecord(String tag) {
        if (!records.containsKey(tag)) { return null; }
        return records.get(tag);
    }

    public ControlRecord getControlRecord(String tag) {
        if (isControlRecord(tag)) { return (ControlRecord)records.get(tag); }
        return null;
    }

    public DataRecord getDataRecord(String tag) {
        if (isDataRecord(tag)) { return (DataRecord)records.get(tag); }
        return null;
    }
}
