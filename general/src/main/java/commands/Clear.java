package commands;

import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

// Очистить коллекцию.
public class Clear implements Command{
    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException{
        if (!args.isEmpty()) throw new IllegalArgumentException("Неизвестные аргументы. Введите help, чтобы узнать доступные команды.");

        labWorks.clear();
        System.out.println("Коллекция очищена.");
        new Info().counterOfMod();
    }
}