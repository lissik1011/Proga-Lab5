package commands.get;

import java.util.Scanner;

public class AuthorName{
    public String getAName(){
        Scanner scan = new Scanner(System.in);
        while (true) { 
            System.out.print("Введите имя автора.\nЕсли автора нет, нажмите enter: ");
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                if (validate(scanName)){
                    return scanName;
                } else {
                    System.out.println("Введено неверное имя, оно содержит двойную кавычку. Если хотите использовать кавычки, используйте одиночные.");
                }
            } else {
                    System.out.println("Введено неверное имя, оно содержит двойную кавычку. Если хотите использовать кавычки, используйте одиночные.");
            }
        }
    }

    private boolean validate(String name){
        return !name.contains("\"");
    }
}