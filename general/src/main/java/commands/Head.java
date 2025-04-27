package commands;

import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

// Вывести первый элемент коллекции.
public class Head implements Command{
    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException{
        if (!args.isEmpty()) throw new IllegalArgumentException("Неизвестные аргументы. Введите help, чтобы узнать доступные команды.");

        if (labWorks.peek() != null) {
            System.out.println(labWorks.peek());
        } else {
            System.out.println("Коллекция пуста.");
        }
    }
}