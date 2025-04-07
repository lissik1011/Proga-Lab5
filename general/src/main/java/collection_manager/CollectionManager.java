package collection_manager;

import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRecord;

public class CollectionManager{
    public void makeFilesCollect(CsvReader<NamedCsvRecord> csv){
        for (NamedCsvRecord rec : csv){
            System.out.println("id = " + rec.getField("id"));
        }
    }
}