package data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import helpfull.Collect;
import helpfull.Validation;

public class LabWork extends Collect implements Validation {
    // private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer minimalPoint; //Поле не может быть null, Значение поля должно быть больше 0
    private Difficulty difficulty; //Поле не может быть null
    private Person author; //Поле может быть null

    public LabWork(String name, Coordinates coordinates,
        Integer minimalPoint, Difficulty difficulty, Person author){
    super();
    this.name = name;
    this.coordinates = coordinates;
    this.creationDate = LocalDateTime.now();
    this.minimalPoint = minimalPoint;
    this.difficulty = difficulty;
    this.author = author;
    }


    // public LabWork(int id, String name, Coordinates coordinates, LocalDateTime creationDate,
    //         Integer minimalPoint, Difficulty difficulty, Person author){
    //     this.id = id;
    //     this.name = name;
    //     this.coordinates = coordinates;
    //     this.creationDate = creationDate;
    //     this.minimalPoint = minimalPoint;
    //     this.difficulty = difficulty;
    //     this.author = author;
    // }

    // public LabWork(int id, String name, Coordinates coordinates, 
    //         Integer minimalPoint, Difficulty difficulty, Person author){
    //     this(id, name, coordinates, LocalDateTime.now(), minimalPoint, difficulty, author);
    // }

    @Override
    public String toString(){
        return String.format("LabWork{id: %d, name: %s,%n coordinates: %s,%n creationDate: %s,%n minimalPoint: %s, difficulty: %s,%n author: {%s} }%n", 
            this.getId(), name, coordinates, 
            creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")),
            minimalPoint, difficulty,
            (author == null ? "null" : author));
    }

    // public String toCSV(){
    //     return String.format("%d, %s, %s, %s, %s, %s, %s", 
    //         id, name, coordinates.toCSV(), 
    //         creationDate, 
    //         minimalPoint, difficulty, 
    //         (author == null ? "null" : author.toCSV()));
    // }

    @Override
    public boolean validate(){
        if (this.getId() <= 0) return false;
        else if (name == null || name.isEmpty()) return false;
        else if (coordinates == null || !coordinates.validate()) return false;
        else if (creationDate == null) return false;
        else if (minimalPoint <= 0) return false;
        else if (difficulty == null) return false;
        else if (author == null || !author.validate()) return false;
        return true;
    }


    @Override
    public int compareTo(Collect element){
        return Long.compare(this.getId(), element.getId());
    }

    // get
    public String getName(){
        return name;
    }
    public Coordinates getCoordinates(){
        return coordinates;
    }
    public LocalDateTime getCreationDate(){
        return creationDate;
    }
    public Integer getMinimalPoint(){
        return minimalPoint;
    }
    public Difficulty getDifficulty(){
        return difficulty;
    }
    public Person getAuthor(){
        return author;
    }

    // set
    public void setName(String name) {
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public void setMinimalPoint(Integer minimalPoint) {
        this.minimalPoint = minimalPoint;
    }
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    public void setAuthor(Person author) {
        this.author = author;
    }

}