package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

public class ExecuteScript implements Command{
    static boolean scannerTypeIsSystemIn = true;

    @Override 
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan){
        if (args.isEmpty()) throw new IllegalArgumentException("Введите название файла, который содержит скрипт.");

        try {
            Path file = Paths.get(args);
            if (Files.exists(file)) {
                CommandMeneger command = new CommandMeneger();

                Scanner scanFile = new Scanner(file);
                scannerTypeIsSystemIn = false;

                while (scanFile.hasNextLine()) {
                    String scancom = scanFile.nextLine();
                    if (scancom.equals("exit")){
                        System.out.println("Заверешение работы программы без сохранения коллекции.");
                        scanFile.close();
                        scannerTypeIsSystemIn = true;
                    } else if (command.thisIsCommand(command.takeCommand(scancom)[0])){
                        String com = command.takeCommand(scancom)[0];
                        String arg = command.takeCommand(scancom)[1];

                        if (arg.equals(args)){
                            System.out.println("Скрипт содержит обращение к себе же. Будет выполняться рекурсивно.");
                            break;
                        }
                        try {
                            command.execute(labWorks, com, arg, scanFile);
                            command.getHistory().addHistory(com);
                            System.out.println();
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch (IllegalStateException e) {
                            break;
                        }
                    } else if (scancom.isEmpty()){
                    } else {
                        System.out.println("Команда не распознана. Исполнение скрипта завершено.\nВведите help, чтобы узнать доступные команды.");
                        break;
                    }
                }
                scannerTypeIsSystemIn = true;
            } else {
                System.out.println("Файл не найден или нет доступа к нему.");
            }
        } catch (IOException e) {}
    }

    public static boolean getScannerType() {
        return scannerTypeIsSystemIn;
    }
}