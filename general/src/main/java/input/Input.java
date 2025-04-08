package input;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

import data.Coordinates;
import data.Difficulty;
import data.LabWork;
import data.Location;
import data.Person;
import de.siegmar.fastcsv.reader.CommentStrategy;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRecord;



public class Input{

    public void input(Queue<LabWork> labWorks, TreeSet<Long> ID){
        Scanner scanner = new Scanner(System.in);
        String empty = "";
        CsvReader<NamedCsvRecord> csv = null;

        while (csv == null){
            System.out.print("Введите название файла: ");
            String file_name = scanner.nextLine();
            Path file = Paths.get(file_name);

            try {
                csv = CsvReader.builder()
                .fieldSeparator(',')
                .quoteCharacter('"')
                .commentStrategy(CommentStrategy.SKIP)
                .commentCharacter('#')
                .skipEmptyLines(true)
                .ignoreDifferentFieldCount(false)
                .acceptCharsAfterQuotes(false)
                .detectBomHeader(true)
                .maxBufferSize(16777216)
                .ofNamedCsvRecord(file);

            } catch (IOException ex) {
                System.out.println("Файл не найден или отсутствует доступ к файлу. Еще раз.");
            } catch (Exception e) {
                System.out.printf("Ошибка чтения файла. Description: " + e.getMessage());   
            }
        }

        try {
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
                        if (!ID.contains(id)){
                            labwork.setId(id);
                            labWorks.add(labwork);
                            ID.add(id);                            
                        } else {
                        System.out.println("Объект с id = " + id + " уже существует. Запись не добавлена. Имя записи: " + name);
                        }
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

        } catch (Exception e) {
            System.out.printf("Ошибка чтения данных. Проверьте их на корректность.\nЧтобы узнать больше информации, введите more или нажмите enter\n");
            Scanner scan = new Scanner(System.in);
            if (scan.nextLine().equals("more")){
                System.out.println(e.getMessage());
            } else {
                System.out.print("");
            }        
        }
    }     
}   
