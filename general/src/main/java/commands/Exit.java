package commands;

import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

// Завершить программу (без сохранения в файл).
public class Exit implements Command{
    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException{
        if (!args.isEmpty()) throw new IllegalArgumentException("Неизвестные аргументы. Введите help, чтобы узнать доступные команды.");
        try (scan) {
            System.out.println("Заверешение работы программы без сохранения коллекции.");
        }
    }
}