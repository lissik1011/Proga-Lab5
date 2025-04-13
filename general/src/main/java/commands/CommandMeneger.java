package commands;

import java.util.Queue;

import data.LabWork;

public class CommandMeneger{

    MakeListOfCommands list = new MakeListOfCommands();

    public boolean thisIsCommand(String scancom){
        return list.getKeys().contains(scancom);
    }
    public void execute(Queue<LabWork> laba, String scancom){
        Command commanda = list.takeList().get(scancom);
        commanda.execute(laba);
    }
}