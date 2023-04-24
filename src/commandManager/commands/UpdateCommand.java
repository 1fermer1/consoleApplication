package commandManager.commands;

public class UpdateCommand implements ICommandable {
    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллеции, id которого равен заданному";
    }

    @Override
    public String getArgs() {
        return "id {element}";
    }

    @Override
    public void execute(String[] args) {

    }
}
