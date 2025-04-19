package commands;

import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

// Вывести элементы, значение поля name которых содержит заданную подстроку.
public class FilterConteinsName implements Command{
    int count = 0;
    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException{
        if (args.isEmpty()) throw new IllegalArgumentException("Введите подстроку.");

        for (LabWork lab : labWorks) {
            if (lab.getName().contains(args)) {
                System.out.println(lab.toString());
                count += 1;
            }
        }
                    
        if (count == 0){
            System.out.println("Лабораторные с заданной подстрокой в названии не найдены.");
        }
    }
}
