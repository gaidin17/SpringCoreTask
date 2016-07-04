package utils.exceptions;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
public class DataBlockedException extends RuntimeException {
    private String message;
    public DataBlockedException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "<br/>" + message + "<br/> ";
    }
}
