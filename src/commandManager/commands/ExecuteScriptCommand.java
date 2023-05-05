package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;
import main.LauncherService;
import main.Mode;
import main.UserInputService;

public class ExecuteScriptCommand implements ICommandable {
    private static Integer iter = 0;
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
    public void execute(String args) throws Exception {
        if (iter>200) {
            UserInputService.setMode(Mode.DEFAULT);
            return;
        }
        iter++;
        UserInputService.setMode(Mode.FILE);
        LauncherService.launcher();
    }
}
