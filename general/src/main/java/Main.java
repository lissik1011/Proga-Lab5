import java.util.ArrayDeque;
import java.util.Queue;

import data.Coordinates;
import data.Difficulty;
import data.LabWork;
import data.Location;
import data.Person;

public class Main {
    static Queue<LabWork> labWorks = new ArrayDeque<>();
    public static void main(String[] args){
        labWorks.add(new LabWork("Liza", new Coordinates(4, (float) 1.23), 10, Difficulty.HARD, 
            new Person("lis", (float) 45.67, "123456789098", new Location((float) 0.687, 8.865, "fi"))));
        labWorks.add(new LabWork("Glafira", new Coordinates(0, (float) 3456.242), 454, Difficulty.HARD, 
            new Person("gl", (float) 354645.67, "22232345098", new Location((float) 9393.687, 234.4325, "lsls"))));
        labWorks.add(new LabWork("Lizzzzzzza", new Coordinates(657483, (float) 35.134), 0101, Difficulty.HARD, 
            null));


        for (var e : labWorks) {
            System.out.println(e);
        }

        // Input file_input = new Input("input.csv", ",");
        // labWorks.addAll(file_input.input());

        // Output file_output = new Output("output.csv", false);
    }
}


/*
    int id;
    String name;
    Coordinates coordinates;
    LocalDateTime creationDate;
    Integer minimalPoint;
    Difficulty difficulty;
    Person author;
*/