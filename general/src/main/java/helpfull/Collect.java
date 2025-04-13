package helpfull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Collect implements Validation{
    private static long counter = Long.parseLong(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS00"))); 
    private final long iD;

    public Collect() {
        this.iD = ++counter; 
    }
    public long takeId() {
        return iD;
    }
    public void printId(){
        System.out.println(counter);
    }
}

