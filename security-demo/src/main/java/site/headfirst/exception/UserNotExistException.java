package site.headfirst.exception;

public class UserNotExistException extends RuntimeException{

    public UserNotExistException(String id) {
        super("user does not exist ecxeption");
        this.id = id;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
