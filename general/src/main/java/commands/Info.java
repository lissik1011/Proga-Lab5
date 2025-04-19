package commands;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

// Вывести информацию о коллекции.
public class Info implements Command{
    static String date = null;
    static String lastDate;
    static int count = 0;

    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException {
        if (!args.isEmpty()) throw new IllegalArgumentException("Неизвестные аргументы. Введите help, чтобы узнать доступные команды.");

        System.out.println("Тип коллекции: Двунаправленная очередь");
        System.out.println("Дата инициализации: " + date);
        System.out.println("Количесво элементов: " + labWorks.size());
        System.out.println("Дата последнего изменения: " + lastDate);
        System.out.println("Количество модификаций: " + count);
        System.out.println("Id первого элемента: " + getFirstId(labWorks));

    }

    public void saveDateOfColl(){
        date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }
    public boolean getDateOfColl(){
        return date != null;
    }

    public void saveLastDateOfMod(){
        lastDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    public void counterOfMod(){
        count += 1;
    }

    public long getFirstId(Deque<LabWork> laba){
        if (!laba.isEmpty()) return laba.getFirst().getId();
        return 0;
    }
}