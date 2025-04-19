package commands;

import java.util.Deque;
import java.util.Scanner;

import data.LabWork;
import output.Output;

// Сохранить коллекцию в файл.
public class Save implements Command {
    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException{
        if (args.isBlank()) throw new IllegalArgumentException("Введите название файла без расширения, в который нужно сохранить коллекцию.");
    
        Output exporter = new Output();
        exporter.output(labWorks, args + ".csv");
    }
}
