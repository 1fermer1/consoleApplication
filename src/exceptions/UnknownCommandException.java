package exceptions;

public class UnknownCommandException extends Exception {
    public UnknownCommandException(String messege) {
        super("Неправльное имя команды или такой команды нет. " + messege);
    }
}
