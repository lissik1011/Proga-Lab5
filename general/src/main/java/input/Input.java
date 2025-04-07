package input;
import java.util.Scanner;

import de.siegmar.fastcsv.reader.CsvReader;


public class Input{

    public void input(String file_name){

        // Iterative reading of some CSV data with a header
        CsvReader.builder().ofNamedCsvRecord("""
        id,header 2,header 3,header 4,header 5,header 6,header 7,header 8,header 9,header 10,header 11,header 12,header 13\n
        field 1,field 2,field 3,field 4,field 5,field 6,field 7,field 8,field 9,field 10,field 11,field 12,field 13
        """)
        .forEach(rec -> System.out.println(rec.getField("header 2")));
    }

    public String scannnerFileName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название файла:");
        String file_name = scanner.nextLine();
        scanner.close();
        return file_name;
    }
}