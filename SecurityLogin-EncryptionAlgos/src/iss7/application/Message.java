package application;
import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 3285199381107694552L;
	private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void encrypt() {
    }

    public void decrypt() {
    }
}