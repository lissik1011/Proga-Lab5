package commands.get;

import java.util.Scanner;

import commands.ExecuteScript;

public class AuthorName{
    public static String getAName(Scanner scan){
        while (true) { 
            if (ExecuteScript.getScannerType()) {System.out.print("Введите имя автора.\nЕсли автора нет, нажмите enter: ");}
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                return scanName;
            } else {
                try (scan) {}
            }
        }
    }
}