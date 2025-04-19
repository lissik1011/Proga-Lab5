package commands;

import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

// Вывести элементы коллекции в порядке возрастания.
public class PrintAscending implements Command{
    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException{
        if (!args.isEmpty()) throw new IllegalArgumentException("Неизвестные аргументы. Введите help, чтобы узнать доступные команды.");
        
        if (labWorks.isEmpty()){
            System.out.println("Коллекция пуста.");
        } else {
            for (LabWork e : labWorks) {
                System.out.println(e.toString());
            }
        }
    }
}
