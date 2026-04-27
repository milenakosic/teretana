package objektno2.fit.exeption;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message){
        super(message);
    }
}
