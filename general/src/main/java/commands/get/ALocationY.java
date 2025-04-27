package commands.get;

import java.util.Scanner;

import commands.ExecuteScript;

public class ALocationY{
    public static double getLocY(Scanner scan){
        boolean bool = true;
        while (bool) { 
            if (ExecuteScript.getScannerType()) {System.out.print("Введите координату локации y (вещественное число): ");}
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                try {
                    double locY = Double.parseDouble(scanName);
                    return locY;
                } catch (NumberFormatException e) {
                    System.out.println("Введены неверные данные.");
                    if (!ExecuteScript.getScannerType()) {
                        bool = false;
                    }
                }
            } else {
                try (scan) {}
            }
        }
        try (scan) {return 1;}
    }
}