package exceptions;

public class StreamInterruptedException extends Exception {
    public StreamInterruptedException(String messege) {
        super("Поток ввода прерван. " + messege);
    }
}
