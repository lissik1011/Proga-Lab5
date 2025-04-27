package commands.get;

import java.util.Scanner;

import commands.ExecuteScript;

public class Name{
    public static String getName(Scanner scan){
        boolean bool = true;
        while (bool) { 
            if (ExecuteScript.getScannerType()) {System.out.print("Введите название работы: ");}
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                if (validate(scanName)){
                    return scanName;
                } else {
                    System.out.println("Введено неверное название, оно пустое или содержит двойную кавычку. Если хотите использовать кавычки, используйте одиночные.");
                    if (!ExecuteScript.getScannerType()) {
                        bool = false;
                    }
                }
            } else {
                try (scan) {}
            }
        }
        try (scan) {return null;}
    }

    private static boolean validate(String name){
        return !name.isEmpty();
    }
}