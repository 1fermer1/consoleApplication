package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;

public class ExecuteScriptCommand implements ICommandable {
    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
    }

    @Override
    public String getArgs() {
        return "file_name";
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {

        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " приниамет только один аргумент");
        }
    }
}
