package commands;

import java.time.LocalDateTime;
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

// Обновить элемент по id
public class Update implements Command{
    Info info = new Info();

    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException{
        if (args.isEmpty()) throw new IllegalArgumentException("Введите id лабораторной работы, которую хотите обновить.");

        try {
            long id = Long.parseLong(args);
            LabWork lab = findLabWorkById(labWorks, id);
            if (lab != null){
                labWorks.remove(lab);
                
                String name = Name.getName(scan);
                int coordinatesX = CoordinatesX.getCoordX(scan);
                float coordinatesY = CoordinatesY.getCoordY(scan);
                LocalDateTime creationDate = lab.getCreationDate();
                int minimalPoint = MinimalPoint.getMinPoint(scan);
                Difficulty difficulty = DifficultyName.getDif(scan);
                String authorName = AuthorName.getAName(scan);
                

                if (authorName.isEmpty()) {
                    LabWork labwork = new LabWork(id, name, new Coordinates(coordinatesX, coordinatesY),
                    creationDate, minimalPoint, difficulty, null);

                    labWorks.add(labwork);
                } else {
                    Float authorWeight = AuthorWeight.getAWeight(scan);
                    String authorPassportId = AuthorPassportId.getAPassportId(scan);
                    Float authorLocationX = ALocationX.getLocX(scan);
                    Double authorLocationY = ALocationY.getLocY(scan);
                    String authorLocationName = ALocName.getALName(scan);            

                    LabWork labwork = new LabWork(id, name, new Coordinates(coordinatesX, coordinatesY),
                    creationDate, minimalPoint, difficulty, 
                    new Person(authorName, authorWeight, authorPassportId, 
                    new Location(authorLocationX, authorLocationY, authorLocationName)));

                    labWorks.add(labwork);

                    GroupCountinfByAuthor setAName = new GroupCountinfByAuthor();
                    if (labwork.getAuthor() != null) {
                        setAName.addAName(labwork.getAuthor().getName());
                    }

                    CollectionManager.sort(labWorks);
                }

                System.out.println("Элемент обновлен.");
                info.saveLastDateOfMod();
                info.counterOfMod();

                if (!info.getDateOfColl()) info.saveDateOfColl();

            } else {
                System.out.println("Лабораторной работы с заданным id нет.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Введен неверный id работы.");
        }
    }

    private LabWork findLabWorkById(Deque<LabWork> labWorks, long id){
        for (LabWork e : labWorks){
            if (e.getId() == id) return e;
        }
        return null;
    }
}
