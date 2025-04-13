package commands.get;

import java.util.Scanner;

public class AuthorWeight{
    public float getAWeight(){
        Scanner scan = new Scanner(System.in);
        while (true) { 
            System.out.print("Введите вес автора (вещественное число): ");
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                try {
                    float weight = Float.parseFloat(scanName);
                    if (this.validate(weight)) return weight;
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
        return name > 0;
    }
}