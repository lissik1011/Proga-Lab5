package commands;

public class Help implements Command{
    @Override
    public void execute(){
        System.out.print("add {element}: ");
        System.out.print("Добавить новый элемент в коллекцию.\n");

        System.out.print("clear: ");
        System.out.print("Очистить коллекцию.\n");

        System.out.print("execute_script {file_name}: ");
        System.out.print("Считать и исполнить скрипт из указанного файла.\n");
    
        System.out.print("exit: ");
        System.out.print("Завершить программу (без сохранения в файл).\n");

        System.out.print("filter_contains_name {name}: ");
        System.out.print("Вывести элементы, значение поля name которых содержит заданную подстроку.\n");
        
        System.out.print("group_counting_by_author: ");
        System.out.print("Сгруппировать элементы коллекции по значению поля author, вывести количество элементов в каждой группе.\n");

        System.out.print("head: ");
        System.out.print("Вывести первый элемент коллекции.\n");

        System.out.print("help: ");
        System.out.print("Вывести справку по доступным командам.\n");

        System.out.print("history: ");
        System.out.print("Вывести последние 12 команд (без их аргументов).\n");

        System.out.print("info: ");
        System.out.print("Вывести информацию о коллекции.\n");

        System.out.print("print_ascending: ");
        System.out.print("Вывести элементы коллекции в порядке возрастания.\n");

        System.out.print("remove_by_id {id}: ");
        System.out.print("Удалить элемент из коллекции по его id.\n");

        System.out.print("remove_greater_by_id {id}: ");
        System.out.print("Удалить из коллекции все элементы, превышающие заданный.\n");

        System.out.print("save: ");
        System.out.print("Сохранить коллекцию в файл.\n");

        System.out.print("show: ");
        System.out.print("Вывести все элементы коллекции в строковом представлении.\n");

        System.out.print("update_by_id {element}: ");
        System.out.print("Обновить значение элемента коллекции, id которого равен заданному.\n");
    }
}