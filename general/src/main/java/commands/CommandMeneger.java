package commands;

import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

public class CommandMeneger{

    MakeListOfCommands list = new MakeListOfCommands();
    History history = new History();

    public void startProg(Deque<LabWork> labWorks, Scanner scan){
        while (true){
            System.out.print("-> ");
            if (scan.hasNextLine()){
                String scancom = scan.nextLine().trim();
                if (scancom.equals("exit")){
                    System.out.println("Заверешение работы программы без сохранения коллекции.");
                    break;
                }
                else if (!loyalCom(scancom)) {
                    System.out.println("Лишнее количество аргументов. Введите help, чтобы узнать доступные команды.");
                }
                else if (thisIsCommand(takeCommand(scancom)[0])){
                    String com = takeCommand(scancom)[0];
                    String arg = takeCommand(scancom)[1];
                    try {
                        execute(labWorks, com, arg, scan);
                        history.addHistory(com);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalStateException e) {
                        break;
                    }
                } else if (scancom.isEmpty()){
                    // continue;
                } else {
                    System.out.println("Команда не распознана. Введите help, чтобы узнать доступные команды.");
                }
            } else {
                break;
            }
        }
    }

    public String[] takeCommand(String request){
        String[] com = request.split("\s+");
        if (com.length == 2) return com;
        return new String[] {request, ""};
    }
    public boolean loyalCom(String request){
        String[] com = request.split("\s+");
        return com.length <= 2;
    }

    public boolean thisIsCommand(String comand){
        return list.getKeys().contains(comand);
    }
    public void execute(Deque<LabWork> laba, String scancom, String args, Scanner scan) throws IllegalArgumentException{
        Command command = list.takeList().get(scancom);
        command.execute(laba, args, scan);
    }

    public History getHistory(){
        return history;
    }
}