package commands.get;

import java.util.Scanner;

public class MinimalPoint{
    public static int getMinPoint(Scanner scan){
        while (true) { 
            System.out.print("Введите минимальный балл (целое число): ");
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                try {
                    int minPoint = Integer.parseInt(scanName);
                    if (minPoint > 0) return minPoint;
                } catch (NumberFormatException e) {
                    System.out.println("Введены неверные данные.");
                }
            } else {
                try (scan) {}
            }
        }
    }
}
