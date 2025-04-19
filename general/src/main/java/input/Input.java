package input;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Deque;
import java.util.Scanner;
import java.util.TreeSet;

import collection_manager.CollectionManager;
import commands.GroupCountinfByAuthor;
import commands.Info;
import data.Coordinates;
import data.Difficulty;
import data.LabWork;
import data.Location;
import data.Person;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRecord;



public class Input{

    public void input(CsvReader<NamedCsvRecord> csv, Deque<LabWork> labWorks, TreeSet<Long> ID, Scanner scan){
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

                    if (rec.getField("author.name").isEmpty()){
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

                            GroupCountinfByAuthor setAName = new GroupCountinfByAuthor();
                            if (labwork.getAuthor() != null) {
                                setAName.addAName(labwork.getAuthor().getName());
                            }

                            CollectionManager.sort(labWorks);
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
            if (!labWorks.isEmpty()){
                System.out.println("Объекты добавлены в коллекцию.");
                new Info().saveDateOfColl();

            } else {
                System.out.println("Объектов нет.");
            }

        } catch (Exception e) {
            System.out.println("Ошибка чтения данных. Проверьте их на корректность.");
            if (!labWorks.isEmpty()){
                System.out.println("Корректные объекты добавлены.");
            }
            System.out.print("Введите more, чтобы узнать больше информации, или нажмите enter: ");
            
            if (scan.nextLine().equals("more")){
                System.out.println(e.getMessage() + "\n");
            } else {
                System.out.println("");
            }
        }
    }     
}   
