package commands;

import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

// Удалить из коллекции все элементы, превышающие заданный.
public class RemoveGreaterById implements Command{
    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException{
        if (args.isEmpty()) throw new IllegalArgumentException("Введите id.");
    
        try {
            long id = Long.parseLong(args);
            if (labWorks.isEmpty()) {
                System.out.println("Коллекция пуста.");
            } else {
                while(labWorks.peekLast().getId() > id){
                    labWorks.pollLast();
                }
                System.out.println("Лабораторных работ с id, превышающими заданный, нет.");
            }   
        } catch (NumberFormatException e) {
            System.out.println("Введен неверный id.");
        }
    }
}
