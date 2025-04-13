package commands.get;

import java.util.Scanner;

public class MinimalPoint{
    public int getMinPoint(){
        Scanner scan = new Scanner(System.in);
        while (true) { 
            System.out.print("Введите минимальный балл (целое число): ");
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                try {
                    int minPoint = Integer.parseInt(scanName);
                    if (this.validate(minPoint)) return minPoint;
                } catch (NumberFormatException e) {
                    System.out.println("Введены неверные данные.");
                }
            } else {
                System.out.println("Введены неверные данные.");
            }
        }
    }

    private boolean validate(int name){
        return name > 0;
    }
}
