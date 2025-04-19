package commands.get;

import java.util.Scanner;

public class CoordinatesX{
    public static int getCoordX(Scanner scan){
        while (true) { 
            System.out.print("Введите координату x (целое число): ");
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                try {
                    int coordinatesX = Integer.parseInt(scanName);
                    return coordinatesX;
                } catch (NumberFormatException e) {
                    System.out.println("Введены неверные данные.");
                }
            } else {
                try (scan) {}
            }
        }
    }
}