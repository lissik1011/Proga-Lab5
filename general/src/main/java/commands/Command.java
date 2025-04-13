package commands;

import java.util.Queue;

import data.LabWork;

public interface Command{
    public void execute(Queue<LabWork> labwork);
}