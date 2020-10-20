package by.gomel.ggmk.exceptions;

import by.gomel.ggmk.enums.Fields;

public class NonPositiveArgumentException  extends IllegalArgumentException{

    private Fields fields;

    public NonPositiveArgumentException() {
        super();
    }

    public NonPositiveArgumentException(String s) {
        super(s);
    }

    public NonPositiveArgumentException(Fields fields) {
        super();
        this.fields = fields;
    }

    public NonPositiveArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonPositiveArgumentException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString(){
        return "In field " + fields + " non positive value";
    }
}
