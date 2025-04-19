package commands.get;

import java.util.Scanner;

public class CoordinatesY{
    public static float getCoordY(Scanner scan){
        while (true) { 
            System.out.print("Введите координату y (вещественное число): ");
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                try {
                    float coordinatesY = Float.parseFloat(scanName);
                    if (coordinatesY > -868) return coordinatesY;
                    else System.out.println("Введены неверные данные.");
                } catch (NumberFormatException e) {
                    System.out.println("Введены неверные данные.");
                }
            } else {
                try (scan) {}
            }
        }
    }
}