package commandManager.commands;

public class ClearCommand implements ICommandable {
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }

    @Override
    public void execute(String[] args) {

    }
}
