package exceptions;

public class IncorrectArgumentException extends Exception {
    public IncorrectArgumentException(String messege) {
        super("Команда не принимает такие аргументы. " + messege);
    }
}
