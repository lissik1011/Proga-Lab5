package commands.get;

import java.util.Scanner;

public class ALocationY{
    public double getLocY(){
        Scanner scan = new Scanner(System.in);
        while (true) { 
            System.out.print("Введите координату локации y (вещественное число): ");
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                try {
                    double locY = Double.parseDouble(scanName);
                    return locY;
                } catch (NumberFormatException e) {
                    System.out.println("Введены неверные данные.");
                }
            } else {
                System.out.println("Введены неверные данные.");
            }
        }
    }
}