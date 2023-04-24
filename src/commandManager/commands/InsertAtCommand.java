package commandManager.commands;

public class InsertAtCommand implements ICommandable {
    @Override
    public String getName() {
        return "insert_at";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в заданную позицию";
    }

    @Override
    public String getArgs() {
        return "index {element}";
    }

    @Override
    public void execute(String[] args) {

    }
}
