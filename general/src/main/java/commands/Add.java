package commands;

import java.util.Scanner;

public class Add implements Command{
    @Override
    public void execute(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = scan.nextLine();
        if (name.contains("\"")){
            
        }

        System.out.println("Введите координату x: ");


        // while (true) {
        //     if (scan.hasNextLine()){
        //         System.out.print("Введите имя: ");
        //         String name = scan.nextLine();

        //         System.out.print("Введите координату x: ");
        //         int coordinatesX = Integer.parseInt(scan.nextLine());
        //     } else {
        //         break;
        //     }
        // }


    }
}