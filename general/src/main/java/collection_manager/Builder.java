package collection_manager;

import data.Coordinates;
import data.Difficulty;
import data.LabWork;
import data.Location;
import data.Person;

public class Builder{

    int id;
    String name;
    int coordinates_x;
    float coordinates_y;
    int minimalPoint;
    String difficulty;
    String author_name;
    float author_weight;
    String author_passportId;
    float author_location_x;
    double author_location_y;
    String author_location_name;

    Difficulty difficulty0 = Difficulty.valueOf(difficulty);

    // В конструктор подать string, а получить тип difficulty. Нам нужен конструктор, который будет создавать данные вне зависимости
    // от того, насколько четко я подам данные.

    public Builder(int id, String name, int coordinates_x, float coordinates_y, int minimalPoint, String difficulty, String author_name){
        this.id = id;
        this.name = name;
        this.coordinates_x = coordinates_x;
        this.coordinates_y = coordinates_y;
        this.minimalPoint = minimalPoint;
        this.difficulty = difficulty0;
        this.author_name = author_name;
    }

    public Builder(int id, String name, int coordinates_x, float coordinates_y, int minimalPoint, Difficulty difficulty,
    String author_name, float author_weight, String author_passportId, 
    float author_location_x, double author_location_y, String author_location_name){
        super();
        this.author_weight = author_weight;
        this.author_passportId = author_passportId;
        this.author_location_x = author_location_x;
        this.author_location_y = author_location_y;
        this.author_location_name = author_location_name;
    }


    public LabWork Builder(){
        Coordinates coordinates = new Coordinates(coordinates_x, coordinates_y);
        if (author_name != null) {
            Location location = new Location(author_location_x, author_location_y, author_location_name);
            Person person = new Person(author_name, author_weight, author_passportId, location);
        }
        else {
            Person person = null;
        }

        LabWork labwork = new LabWork(id, name, coordinates, minimalPoint, difficulty, person);
        return labwork;
    }
}