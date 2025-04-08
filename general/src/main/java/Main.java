import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeSet;

import data.LabWork;
import input.Input;

public class Main {
    static Queue<LabWork> labWorks = new ArrayDeque<>();
    static TreeSet<Long> ID = new TreeSet<>();
    public static void main(String[] args){

        // Output exporter = new Output();
        // exporter.output(labWorks, "output.csv");

        Input reader = new Input();
        reader.input(labWorks, ID);

        for (var e : labWorks) {
            System.out.println(e);
        }
        
    }
}