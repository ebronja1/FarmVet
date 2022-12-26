package ba.unsa.etf.rpr.exceptions;

public class FarmVetException extends Exception{

    public FarmVetException(String msg, Exception reason){
        super(msg, reason);
    }

    public FarmVetException(String msg){
        super(msg);
    }
}

