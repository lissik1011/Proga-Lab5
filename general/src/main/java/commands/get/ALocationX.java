package commands.get;

import java.util.Scanner;

import commands.ExecuteScript;

public class ALocationX {
    public static float getLocX(Scanner scan){
        boolean bool = true;
        while (bool) { 
            if (ExecuteScript.getScannerType()) {System.out.print("Введите координату локации x (вещественное число): ");}
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                try {
                    float locX = Float.parseFloat(scanName);
                    return locX;
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