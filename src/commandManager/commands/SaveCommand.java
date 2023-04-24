package commandManager.commands;

public class SaveCommand implements ICommandable {
    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }

    @Override
    public void execute(String[] args) {
// TODO: в джсон записываем также как выводит zoneddatetime т.е. 24-12-2000T12:12:34.898989
    }
}
