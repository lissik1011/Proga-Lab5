package collection_manager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

import data.LabWork;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRecord;

public class CollectionManager{
    public void makeFilesCollect(CsvReader<NamedCsvRecord> csv){
        for (NamedCsvRecord rec : csv){
            System.out.println("id = " + rec.getField("id"));
        }
    }

    public static Deque<LabWork> sort(Deque<LabWork> labWorks){
        List<LabWork> sorted = new ArrayList<>(labWorks);
        sorted.sort(Comparator.comparingLong(LabWork::getId));

        labWorks.clear();
        labWorks.addAll(sorted);
        return labWorks;
    }
}