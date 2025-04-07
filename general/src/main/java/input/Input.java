package input;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

import data.LabWork;

public class Input{
    String delimiter;
    String fileName;

    public Input(String fileName, String delimiter){
        this.fileName = fileName;
        this.delimiter = delimiter;
    }

    public Queue input(){
        Queue<LabWork> labWorks = new ArrayDeque<>();

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(delimiter);

            while (scanner.hasNextLine()){

                String person = scanner.nextLine();

                // Через join разделить на строки и передать их в Builder. Можно ли (int) "4" ?

                // Построить объект в зависимости от кол-ва данных. Хотелось бы подать массив, чтобы он сам решил, чем будет 
                // являться, однако не знаю как это можно сделать.
                // Builder Lab = new Builder();

                // CollectionManager collect = new CollectionManager(Lab);
                // Хотелось бы, чтобы collectManager добавлял объекты в коллекцию. Будем ли мы реализовывать сериализацию?
                // Нужно будет немного структурировать лабу. А то не совсем понятны этапы реализации.
                
            }

            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден.");
        }

        return labWorks;

    }
}


// int id = scanner.nextInt();
// String name = scanner.next();
// int coordinates_x = scanner.nextInt();
// float coordinates_y = scanner.nextFloat();
// int minimalPoint = scanner.nextInt();
// String difficulty = scanner.next();
// String author_name = scanner.next();
// float author_weight = scanner.nextFloat();
// String author_passportId = scanner.next();
// float author_location_x = scanner.nextFloat();
// double author_location_y = scanner.nextDouble();
// String author_location_name = scanner.next();