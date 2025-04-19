package commands;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

// Вывести последние 12 команд (без их аргументов).
public class History implements Command {
    static Deque<String> history = new ArrayDeque<>();

    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException{
        if (!args.isEmpty()) throw new IllegalArgumentException("Неизвестные аргументы. Введите help, чтобы узнать доступные команды.");

        if (!history.isEmpty()) {
            for (String e : history) {
                System.out.println(e);
            }
        } else {
            System.out.println("");
        }
    }

    public void addHistory(String com){
        history.addLast(com);
        if (history.size() > 12) {
            history.pollFirst();
        }
    }
}