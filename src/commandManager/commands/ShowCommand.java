package commandManager.commands;

// TODO: чтобы после каждого кроме последнего элемента была запятая
public class ShowCommand implements ICommandable {
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все эементы коллекции в строковом представлении";
    }

    @Override
    public void execute(String[] args) {

    }
}
