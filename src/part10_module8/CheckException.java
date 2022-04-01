package part10_module8;

public class CheckException extends Exception {

    final String symbol;


    public String getSymbol () {
        return symbol;
    }

    public CheckException (String message, String symbol) {
        super (message);
        this.symbol = symbol;
    }
}
