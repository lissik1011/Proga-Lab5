package commands.get;

import java.util.Scanner;

public class Name{
    public String getName(){
        Scanner scan = new Scanner(System.in);
        while (true) { 
            System.out.print("Введите название работы: ");
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                if (validate(scanName)){
                    return scanName;
                } else {
                    System.out.println("Введено неверное название, оно пустое или содержит двойную кавычку. Если хотите использовать кавычки, используйте одиночные.");
                }
            } else {
                    System.out.println("Введено неверное название, оно пустое или содержит двойную кавычку. Если хотите использовать кавычки, используйте одиночные.");
            }
        }
    }

    private boolean validate(String name){
        return !name.isEmpty() && !name.contains("\"");
    }
}