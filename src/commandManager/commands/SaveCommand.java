package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;

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
    public void execute(String[] args) throws Exception {
        // TODO: в джсон записываем также как выводит zoneddatetime т.е. 24-12-2000T12:12:34.898989

        // https://developer.alexanderklimov.ru/android/library/gson.php
        // gson для парса json

        if (args.length == 0) {

        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " не принимает аргументы");
        }
    }
}
