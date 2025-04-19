package commands;

import java.util.Deque;
import java.util.Scanner;

import data.LabWork;

public interface Command{
    // protected void run() {
    //     this.validtad();
    //     this.execute(labwork, args);
    // }
    
    public void execute(Deque<LabWork> labWorks, String args, Scanner scan) throws IllegalArgumentException;
}

// @Override
// public void execute(Deque<LabWork> labWork, String args) throws Exception{
//     if (!args.isEmpty()) throw new Exception("Неизвестные аргументы. Введите help, чтобы узнать доступные команды.");
