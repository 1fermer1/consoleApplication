package exceptions;

public class CommandInterrupterException extends Exception {
    public CommandInterrupterException(String messege) {
        super("Команда прервана. " + messege);
    }
}
