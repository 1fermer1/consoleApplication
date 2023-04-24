package commandManager;

import commandManager.commands.*;

import java.util.LinkedHashMap;

public class CommandManager {
    private LinkedHashMap<String, ICommandable> commands;

    public LinkedHashMap<String, ICommandable> getCommands() {
        return commands;
    }

    public CommandManager() {
        commands = new LinkedHashMap<>();

        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("add", new AddCommand());
        commands.put("update", new UpdateCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("clear", new ClearCommand());
        commands.put("save", new SaveCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("exit", new ExitCommand());
        commands.put("insert_at", new InsertAtCommand());
        commands.put("reorder", new ReorderCommand());
        commands.put("history", new HistoryCommand());
        commands.put("count_less_than_distance", new CountLessThanDistanceCommand());
        commands.put("print_ascending", new PrintAscendingCommand());
        commands.put("print_descending", new PrintDescendingCommand());
    }
}
