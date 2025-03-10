package ca.cal.tp2.Execption;

public class DataBaseErrorException extends RuntimeException {
    public DataBaseErrorException(String message) {
        super(message);
    }
}
