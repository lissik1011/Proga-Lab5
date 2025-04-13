package commands;

import java.util.HashMap;
import java.util.Set;

public class MakeListOfCommands{
    public static final HashMap<String, Command> listCommands = new HashMap<>();

    HashMap<String, Command> takeList(){
        return listCommands;
    }

    Set<String> getKeys(){
        return listCommands.keySet();
    }

    public void addRecord(String name, Command command){
        listCommands.put("name", command);
    }

    static {
        listCommands.put("add", new Add());
        listCommands.put("clear", new Help());
        listCommands.put("execute_script", new Help());
        listCommands.put("exit", new Help());
        listCommands.put("filter_contains_name", new Help());
        listCommands.put("group_counting_by_author", new Help());
        listCommands.put("head", new Help());
        listCommands.put("help", new Help());
        listCommands.put("history", new Help());
        listCommands.put("info", new Help());
        listCommands.put("print_ascending", new Help());
        listCommands.put("remove_by_id", new Help());
        listCommands.put("remove_greater_by_id", new Help());
        listCommands.put("save", new Help());
        listCommands.put("show", new Help());
        listCommands.put("update_by_id", new Help());
    }
}