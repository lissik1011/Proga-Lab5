package commands.get;

import java.util.Scanner;

public class ALocName{
    public String getALName(){
        Scanner scan = new Scanner(System.in);
        while (true) { 
            System.out.print("Введите название локации: ");
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