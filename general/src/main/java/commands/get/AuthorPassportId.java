package commands.get;

import java.util.Scanner;

public class AuthorPassportId{
    public String getAPassportId(){
        Scanner scan = new Scanner(System.in);
        while (true) { 
            System.out.print("Введите паспортный идентификатор автора: ");
            if (scan.hasNextLine()){
                String scanName = scan.nextLine();
                if (validate(scanName)){
                    return scanName;
                } else {
                    System.out.println("Введен неверный id, он пустой или содержит двойную кавычку. Если хотите использовать кавычки, используйте одиночные.");
                }
            } else {
                    System.out.println("Введен неверный id, он пустой или содержит двойную кавычку. Если хотите использовать кавычки, используйте одиночные.");
            }
        }
    }

    private boolean validate(String name){
        return !name.isEmpty() && !name.contains("\"");
    }
}