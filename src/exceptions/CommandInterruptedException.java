package exceptions;

public class CommandInterruptedException extends Exception {
    public CommandInterruptedException(String messege) {
        super("Выполнение команды прервано. " + messege);
    }
}
