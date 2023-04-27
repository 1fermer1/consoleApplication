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
// вставить в эдд енам с модом, если мод скрипта, а не юзера, то вместо повторных сообщений о вводе пробрасываем исключение

            // сделать счетчик вызова скрипт команды и если доходит число до N (или например 500) то делаем вид что избавляемся от рекурсии и прекращаем скрипты
        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " приниамет только один аргумент");
        }
    }
}
