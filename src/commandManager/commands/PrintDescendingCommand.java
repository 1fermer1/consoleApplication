package commandManager.commands;

public class PrintDescendingCommand implements ICommandable {
    @Override
    public String getName() {
        return "print_descending";
    }

    @Override
    public String getDescription() {
        return "вывести элементы коллекции в порядке убывания";
    }

    @Override
    public void execute(String[] args) {

    }
}
