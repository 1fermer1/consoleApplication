package commandManager.commands;

public class ReorderCommand implements ICommandable {
    @Override
    public String getName() {
        return "reorder";
    }

    @Override
    public String getDescription() {
        return "отсортировать коллекцию в порядке, обратном нынешнему";
    }

    @Override
    public void execute(String[] args) {

    }
}
