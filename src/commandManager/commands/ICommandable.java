package commandManager.commands;

public interface ICommandable {
    public String getName();

    public String getDescription();

    public default String getArgs() {
        return "";
    }

    public void execute(String args) throws Exception;
}
