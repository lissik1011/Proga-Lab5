package output;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

import data.LabWork;

public class Output{
    String fileName;
    boolean append;

    public Output(String fileName, boolean append){
        this.fileName = fileName;
        this.append = append;
    }

    public void output(Queue<LabWork> labWorks) throws IOException{
        try (FileWriter writer = new FileWriter(fileName, append)){
            writer.write("id, name, coordinates.x, coordinates.y, creationDate, minimalPoint, difficulty, author.name, author.weight, author.passportId, author.location.x, author.location.y, author.location.name\n");

            for (LabWork people : labWorks){
                writer.write(people.toString() + "\n");
            }
            System.out.println("CSV-файл успешно записан. Имя файла: " + fileName);
        }
    }
}