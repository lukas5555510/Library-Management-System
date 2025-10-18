package util;

public class BookError extends RuntimeException{
    public BookError(String message){
        super(message);
    }
    public BookError(Throwable cause){
        super(cause);
    }
    public BookError(String message, Throwable cause){
        super(message, cause);
    }
}
