package exception;

public class NotBrowserException extends Exception {

    public NotBrowserException(String browser){
        super(String.format("Browser %s not supported", browser));
    }
}
