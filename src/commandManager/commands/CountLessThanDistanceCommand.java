package commandManager.commands;

public class CountLessThanDistanceCommand implements ICommandable {
    @Override
    public String getName() {
        return "count_less_than_distance";
    }

    @Override
    public String getDescription() {
        return "вывести количество элементов, значение поля distance которых меньше заданного";
    }

    @Override
    public String getArgs() {
        return "distance";
    }

    @Override
    public void execute(String[] args) {

    }
}
