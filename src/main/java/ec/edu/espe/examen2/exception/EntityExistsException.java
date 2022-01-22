package ec.edu.espe.examen2.exception;

public class EntityExistsException extends RuntimeException{

    public EntityExistsException(String msg) {
        super(msg);
    }
    
}
