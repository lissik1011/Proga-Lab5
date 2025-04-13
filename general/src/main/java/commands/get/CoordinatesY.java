package commands.get;

import java.util.Scanner;

public class CoordinatesY{
    public float getCoordY(){
        Scanner scan = new Scanner(System.in);
        while (true) { 
            System.out.print("Введите координату y (вещественное число): ");
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                try {
                    float coordinatesY = Float.parseFloat(scanName);
                    if (this.validate(coordinatesY)) return coordinatesY;
                    else System.out.println("Введены неверные данные.");
                } catch (NumberFormatException e) {
                    System.out.println("Введены неверные данные.");
                }
            } else {
                System.out.println("Введены неверные данные.");
            }
        }
    }

    private boolean validate(float name){
        return name > -868;
    }
}