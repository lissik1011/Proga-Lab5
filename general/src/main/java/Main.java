import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

import commands.CommandMeneger;
import data.LabWork;
import input.Input;
import input.TakeCsv;

public class Main {
    static Queue<LabWork> labWorks = new ArrayDeque<>();
    static TreeSet<Long> ID = new TreeSet<>();
    public static void main(String[] args){
        try {
            String file_name = args[0];
            Path file = Paths.get(file_name);

            if (Files.exists(file)){
                TakeCsv csv = new TakeCsv();
                new Input().input(csv.takeCsv(file), labWorks, ID);    
            } else {
                System.out.println("Файл не найден или нет доступа к нему. Коллекция пустая.");
            }
        } catch (Exception e) {}


        // for (var e : labWorks) {
        //     System.out.println(e);
        // }

        // Output exporter = new Output();
        // exporter.output(labWorks, "output2.csv");

        Scanner scan = new Scanner(System.in);
        CommandMeneger command = new CommandMeneger();

        while (true){
            System.out.print("-> ");
            if (scan.hasNextLine()){
                String scancom = scan.nextLine().trim();
                if (command.thisIsCommand(scancom)){
                    command.execute(labWorks, scancom);
                } else if (scancom.isEmpty()){
                } else {
                    System.out.println("Команда не распознана. Введите help, чтобы узнать доступные команды.");
                }
            } else {
                break;
            }
        }
    }
}