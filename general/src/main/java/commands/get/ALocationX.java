package commands.get;

import java.util.Scanner;

public class ALocationX{
    public float getLocX(){
        Scanner scan = new Scanner(System.in);
        while (true) { 
            System.out.print("Введите координату локации x (вещественное число): ");
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                try {
                    float locX = Float.parseFloat(scanName);
                    return locX;
                } catch (NumberFormatException e) {
                    System.out.println("Введены неверные данные.");
                }
            } else {
                System.out.println("Введены неверные данные.");
            }
        }
    }
}