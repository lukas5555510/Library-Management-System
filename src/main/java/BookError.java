public class BookError extends RuntimeException{
    BookError(String message){
        super(message);
    }
    BookError(Throwable cause){
        super(cause);
    }
    BookError(String message, Throwable cause){
        super(message, cause);
    }
}
