package commands;

import java.util.Deque;
import java.util.Scanner;

import collection_manager.CollectionManager;
import commands.get.ALocName;
import commands.get.ALocationX;
import commands.get.ALocationY;
import commands.get.AuthorName;
import commands.get.AuthorPassportId;
import commands.get.AuthorWeight;
import commands.get.CoordinatesX;
import commands.get.CoordinatesY;
import commands.get.DifficultyName;
import commands.get.MinimalPoint;
import commands.get.Name;
import data.Coordinates;
import data.Difficulty;
import data.LabWork;
import data.Location;
import data.Person;

// Добавить новый элемент в коллекцию.
public class Add implements Command{
    Info info = new Info();

    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException{
        if (!args.isEmpty()) throw new IllegalArgumentException("Неизвестные аргументы. Введите help, чтобы узнать доступные команды.");

        System.out.println("Введите элементы лабораторной работы.");
        
        String name = Name.getName(scan);
        int coordinatesX = CoordinatesX.getCoordX(scan);
        float coordinatesY = CoordinatesY.getCoordY(scan);
        int minimalPoint = MinimalPoint.getMinPoint(scan);
        Difficulty difficulty = DifficultyName.getDif(scan);
        String authorName = AuthorName.getAName(scan);
        

        if (authorName.isEmpty()) {
            LabWork labwork = new LabWork(name, new Coordinates(coordinatesX, coordinatesY),
            minimalPoint, difficulty, null);

            labWorks.add(labwork);
        } else {
            Float authorWeight = AuthorWeight.getAWeight(scan);
            String authorPassportId = AuthorPassportId.getAPassportId(scan);
            Float authorLocationX = ALocationX.getLocX(scan);
            Double authorLocationY = ALocationY.getLocY(scan);
            String authorLocationName = ALocName.getALName(scan);            

            LabWork labwork = new LabWork(name, new Coordinates(coordinatesX, coordinatesY),
            minimalPoint, difficulty, 
            new Person(authorName, authorWeight, authorPassportId, 
            new Location(authorLocationX, authorLocationY, authorLocationName)));

            labWorks.add(labwork);

            GroupCountinfByAuthor setAName = new GroupCountinfByAuthor();
            if (labwork.getAuthor() != null) {
                setAName.addAName(labwork.getAuthor().getName());
            }

            CollectionManager.sort(labWorks);
        }

        System.out.println("Элемент добавлен в коллекцию.");
        info.saveLastDateOfMod();
        info.counterOfMod();

        if (!info.getDateOfColl()) info.saveDateOfColl();
    }
}