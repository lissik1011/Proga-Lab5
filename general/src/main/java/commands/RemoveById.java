package commands;

import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

// Удалить элемент из коллекции по его id.
public class RemoveById implements Command{
    @Override
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException{
        if (args.isEmpty()) throw new IllegalArgumentException("Введите id работы, которую хотите удалить.");
        
        try {
            long id = Long.parseLong(args);
            if (labWorks.isEmpty()) {
                System.out.println("Коллекция пуста.");
            } else {
                LabWork lab = findLabWorkById(labWorks, id);
                if (lab == null) System.out.println("Работы с таким id не существует.");
                else {
                    labWorks.remove(lab);
                    System.out.println("Элемент с id = " + id + " успешно удален.");
                }
            }   
        } catch (NumberFormatException e) {
            System.out.println("Введен неверный id работы.");
        }

    }

    private LabWork findLabWorkById(Deque<LabWork> labWorks, long id){
        for (LabWork e : labWorks){
            if (e.getId() == id) return e;
        }
        return null;
    }
}
