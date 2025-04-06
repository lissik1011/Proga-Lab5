package output;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

import data.*;
import de.siegmar.fastcsv.writer.*;

public class Output2{

    public void output(Queue<LabWork> labWorks, String file_name) throws IOException{
        File file = new File(file_name);
        file.getParentFile().mkdirs();

        try (FileWriter writer = new FileWriter(file);
            CsvAppender csv = CsvWriter.builder().build(writer)) {

            csv.appendLine("id", "name", "coordinates.x", "coordinates.y", "creationDate",
            "minimalPoint", "difficulty", "author.name", "author.weight",
            "author.passportId", "author.location.x", "author.location.y", "author.location.name");
            
            for (LabWork labWork : labWorks){

                String author_name = labWork.getAuthor().getName();
                csv.appendLine(
                        String.valueOf(labWork.getId()),
                        labWork.getName(),
                        String.valueOf(labWork.getCoordinates().getX()),
                        String.valueOf(labWork.getCoordinates().getY()),
                        labWork.getCreationDate().toString(),
                        String.valueOf(labWork.getMinimalPoint()),
                        labWork.getDifficulty().toString(),

                        author_name != null ? labWork.getAuthor().getName() : "",
                        author_name != null ? String.valueOf(labWork.getAuthor().getWeight()) : "",
                        author_name != null ? labWork.getAuthor().getPassportID() : "",
                        author_name != null ? String.valueOf(labWork.getAuthor().getLocation().getX()) : "",
                        author_name != null ? String.valueOf(labWork.getAuthor().getLocation().getY()) : "",
                        author_name != null ? labWork.getAuthor().getLocation().getName() : "");
            }
        }
    }
}