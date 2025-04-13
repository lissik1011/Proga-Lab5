package commands.get;

import java.util.Scanner;

import data.Difficulty;

public class DifficultyName{
    public Difficulty getDif(){
        Scanner scan = new Scanner(System.in);
        while (true) { 
            System.out.print("Выберите трудность\n1 - Hard, 2 - Hopeless, 3 - Terrible: ");
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                try {
                    int dif = Integer.parseInt(scanName);
                    switch (dif) {
                        case 1 -> {
                            return Difficulty.valueOf("HARD");
                        }
                        case 2 -> {
                            return Difficulty.valueOf("HOPELESS");
                        }
                        case 3 -> {
                            return Difficulty.valueOf("TERRIBLE");
                        }
                        default -> System.out.println("Введены неверные данные.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введены неверные данные.");
                }
            } else {
                System.out.println("Введены неверные данные.");
            }
        }
    }
}
