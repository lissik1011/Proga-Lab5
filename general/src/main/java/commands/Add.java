package commands;

import java.util.Queue;

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


public class Add implements Command{
    @Override
    public void execute(Queue<LabWork> labWork){
        System.out.println("Введите элементы лабораторной работы. Для выхода нажмите enter:");

        String name = new Name().getName();
        int coordinatesX = new CoordinatesX().getCoordX();
        float coordinatesY = new CoordinatesY().getCoordY();
        int minimalPoint = new MinimalPoint().getMinPoint();
        Difficulty difficulty = new DifficultyName().getDif();
        String authorName = new AuthorName().getAName();

        if (authorName.isEmpty()) {
            LabWork labwork = new LabWork(name, new Coordinates(coordinatesX, coordinatesY),
            minimalPoint, difficulty, null);

            labWork.add(labwork);
        } else {
            Float authorWeight = new AuthorWeight().getAWeight();
            String authorPassportId = new AuthorPassportId().getAPassportId();
            Float authorLocationX = new ALocationX().getLocX();
            Double authorLocationY = new ALocationY().getLocY();
            String authorLocationName = new ALocName().getALName();

            LabWork labwork = new LabWork(name, new Coordinates(coordinatesX, coordinatesY),
            minimalPoint, difficulty, 
            new Person(authorName, authorWeight, authorPassportId, 
            new Location(authorLocationX, authorLocationY, authorLocationName)));

            labWork.add(labwork);
        }

        System.out.println("Элемент добавлен в коллекцию.");
    }
}