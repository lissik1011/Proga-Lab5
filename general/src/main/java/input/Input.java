package input;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Queue;
import java.util.Scanner;

import data.Coordinates;
import data.Difficulty;
import data.LabWork;
import data.Location;
import data.Person;
import de.siegmar.fastcsv.reader.CommentStrategy;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRecord;



public class Input{

    public void input(Queue<LabWork> labWorks){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String file_name = scanner.nextLine();
        Path file = Paths.get(file_name);
        String empty = "";

        try (CsvReader<NamedCsvRecord> csv = CsvReader.builder().fieldSeparator(',').quoteCharacter('"')
            .commentStrategy(CommentStrategy.SKIP).commentCharacter('#')
            .skipEmptyLines(true).ignoreDifferentFieldCount(false)
            .acceptCharsAfterQuotes(false).detectBomHeader(true)
            .maxBufferSize(16777216).ofNamedCsvRecord(file)) {

            LabWork labwork;

            for (NamedCsvRecord rec : csv){
                try {
                    long id = Long.parseLong(rec.getField("id"));
                    String name = rec.getField("name");
                    int coordinatesX = Integer.parseInt(rec.getField("coordinates.x"));
                    float coordinatesY = Float.parseFloat(rec.getField("coordinates.y"));
                    LocalDateTime creationDate = LocalDateTime.parse(rec.getField("creationDate"));
                    int minimalPoint = Integer.parseInt(rec.getField("minimalPoint"));
                    Difficulty difficulty =  Difficulty.valueOf(rec.getField("difficulty"));
                    if (empty.equals(rec.getField("author.name"))){
                        labwork = new LabWork(id, name, new Coordinates(coordinatesX, coordinatesY), creationDate,
                        minimalPoint, difficulty, null);  
                    }
                    else {
                        String authorName = rec.getField("author.name");
                        Float authorWeight = Float.valueOf(rec.getField("author.weight"));
                        String authorPassportId = rec.getField("author.passportId");
                        Float authorLocationX = Float.valueOf(rec.getField("author.location.x"));
                        Double authorLocationY = Double.valueOf(rec.getField("author.location.y"));
                        String authorLocationName = rec.getField("author.location.name");

                        labwork = new LabWork(id, name, new Coordinates(coordinatesX, coordinatesY), creationDate,
                        minimalPoint, difficulty, 
                        new Person(authorName, authorWeight, authorPassportId, 
                        new Location(authorLocationX, authorLocationY, authorLocationName)));                        
                    }

                    if (labwork.validate()) {
                        labWorks.add(labwork);
                    }
                    else {
                        System.out.println("Объект с id = " + id + " не был добавлен в коллекцию. Данные не валидные.");
                    }


                } catch (NumberFormatException e) {
                    System.out.println("Неверные данные. Объект не добавлен. Id записи: " + rec.getField("id") + ". Ошибка преобразования числа: " + e.getMessage());
                } catch (DateTimeParseException e) {
                    System.out.println("Неверные данные. Объект не добавлен. Id записи: " + rec.getField("id") + ". Ошибка преобразования даты: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Неверные данные. Объект не добавлен. Id записи: " + rec.getField("id") + ". Ошибка преобразования значения в difficulty: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage() + "Неверные данные. Объект не добавлен. Id записи = " + rec.getField("id"));
                }
            }
            System.out.println("Объекты добавлены в коллекцию.");

        } catch (IOException ex) {
            System.out.println("Файл не найден или отсутствует доступ к файлу.");
            this.input(labWorks); // Метод input может рекурсивно выполняться, если не переопределен в подклассах.
        }
    }        
}