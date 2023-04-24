package commandManager.commands;

public class ExitCommand implements ICommandable {
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "завершить программу (без сохранения в файл)";
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.exit(0);
        } else {
            // TODO: сделать аргумент ексепшен (чтобы команда не попала в историю)
        }
    }
}
