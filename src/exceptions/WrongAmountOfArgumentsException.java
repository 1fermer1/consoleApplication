package exceptions;

public class WrongAmountOfArgumentsException extends Exception {
    public WrongAmountOfArgumentsException(String messege) {
        super("Неправльное количество аргументов команды. " + messege);
    }
}
