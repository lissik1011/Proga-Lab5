import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.TreeSet;

import commands.CommandMeneger;
import data.LabWork;
import input.Input;
import input.TakeCsv;

public class Main {
    static Deque<LabWork> labWorks = new ArrayDeque<>();
    static TreeSet<Long> idSet = new TreeSet<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        try {
            String file_name = args[0];
            Path file = Paths.get(file_name);

            if (Files.exists(file)){
                new Input().input(TakeCsv.takeCsv(file), labWorks, idSet, scan);    
            } else {
                System.out.println("Файл не найден или нет доступа к нему. Коллекция пустая.");
            }
        } catch (Exception e) {}

        CommandMeneger command = new CommandMeneger();
        command.startProg(labWorks, scan);
    }
}



// Output exporter = new Output();
// exporter.output(labWorks, "output2.csv");