package helpfull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Collect implements Comparable<Collect>, Validation{
    private static long counter = Long.parseLong(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss001"))); 
    private final long id;

    public Collect() {
        this.id = ++counter; 
    }
    public long getId() {
        return id;
    }
    public void printId(){
        System.out.println(counter);
    }
}

