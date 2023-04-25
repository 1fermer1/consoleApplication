package commandManager.commands;

import exceptions.BuildObjectException;
import exceptions.CommandInterruptedException;
import exceptions.WrongAmountOfArgumentsException;

public interface ICommandable {
    public String getName();

    public String getDescription();

    public default String getArgs() {
        return "";
    }

    public void execute(String[] args) throws Exception;
}
