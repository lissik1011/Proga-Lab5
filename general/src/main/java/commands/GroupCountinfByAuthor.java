package commands;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import data.LabWork;

// Сгруппировать элементы коллекции по значению поля author, вывести количество элементов в каждой группе.
public class GroupCountinfByAuthor implements Command{
    static Map<String, Integer> authorName = new HashMap<>();
    int nullCounter = 0;

    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException{
        if (!args.isEmpty()) throw new IllegalArgumentException("Неизвестные аргументы. Введите help, чтобы узнать доступные команды.");
        

        if (!labWorks.isEmpty()) {        
            for (LabWork lab : labWorks){
                if (lab.getAuthor() != null){
                    Integer authorCount = authorName.get(lab.getAuthor().getName());
                    authorName.put(lab.getAuthor().getName(), authorCount + 1);
                } else {
                    nullCounter += 1;
                }
            }

            Set<String> keys = authorName.keySet();
            for (String key : keys){
                System.out.println(key + ": " + authorName.get(key));
            }

            System.out.println("Кол-во лабораторных работ без автора: " + nullCounter);
        } else {
            System.out.println("Коллекция пуста.");
        }
    }

    public void addAName(String name){
        authorName.put(name, 0);
    }
}
