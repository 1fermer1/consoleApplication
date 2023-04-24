package commandManager.commands;

public class PrintAscendingCommand implements ICommandable {
    @Override
    public String getName() {
        return "print_ascending";
    }

    @Override
    public String getDescription() {
        return "вывести элементы коллекции в порядке возрастания";
    }

    @Override
    public void execute(String[] args) {

    }
}
