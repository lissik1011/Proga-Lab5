package commands;

public class CommandMeneger{

    MakeListOfCommands list = new MakeListOfCommands();

    public boolean thisIsCommand(String scancom){
        return list.getKeys().contains(scancom);
    }
    public void execute(String scancom){
        Command command = list.takeList().get(scancom);
        command.execute();
    }
}