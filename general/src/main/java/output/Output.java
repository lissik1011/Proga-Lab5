package output;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

import data.LabWork;
import de.siegmar.fastcsv.writer.CsvWriter;

public class Output{

    public void output(Queue<LabWork> labWorks, String file_name){
        File file = new File(file_name);

        try (FileWriter writer = new FileWriter(file);
            CsvWriter csv = CsvWriter.builder().build(writer)) {

            csv.writeRecord("id", "name", "coordinates.x", "coordinates.y", "creationDate",
            "minimalPoint", "difficulty", "author.name", "author.weight",
            "author.passportId", "author.location.x", "author.location.y", "author.location.name");
            
            for (LabWork labWork : labWorks){

                csv.writeRecord(
                        String.valueOf(labWork.getId()),
                        labWork.getName(),
                        String.valueOf(labWork.getCoordinates().getX()),
                        String.valueOf(labWork.getCoordinates().getY()),
                        labWork.getCreationDate().toString(),
                        String.valueOf(labWork.getMinimalPoint()),
                        labWork.getDifficulty().toString(),

                        labWork.getAuthor() != null ? labWork.getAuthor().getName() : "",
                        labWork.getAuthor() != null ? String.valueOf(labWork.getAuthor().getWeight()) : "",
                        labWork.getAuthor() != null ? labWork.getAuthor().getPassportID() : "",
                        labWork.getAuthor() != null ? String.valueOf(labWork.getAuthor().getLocation().getX()) : "",
                        labWork.getAuthor() != null ? String.valueOf(labWork.getAuthor().getLocation().getY()) : "",
                        labWork.getAuthor() != null ? labWork.getAuthor().getLocation().getName() : "");
            }
            System.out.println("CSV-файл успешно записан. Название файла: " + file_name);
        }
        catch (IOException e){
                System.out.println("Неверный формат файла.");
        }
    }
}