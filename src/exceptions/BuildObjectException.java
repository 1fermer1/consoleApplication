package exceptions;

public class BuildObjectException extends Exception {
    public BuildObjectException(String messege) {
        super("Неправильное создание объекта. " + messege);
    }
}
