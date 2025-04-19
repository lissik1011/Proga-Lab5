package commands;

import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

// Вывести все элементы коллекции в строковом представлении.
public class Show implements Command {
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
