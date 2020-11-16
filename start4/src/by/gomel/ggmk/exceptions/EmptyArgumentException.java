package by.gomel.ggmk.exceptions;

import by.gomel.ggmk.enums.Fields;

public class EmptyArgumentException extends IllegalArgumentException{

    private Fields fields;

    public EmptyArgumentException() {
        super();
    }

    public EmptyArgumentException(String s) {
        super(s);
    }

    public EmptyArgumentException(Fields fields) {
        super();
        this.fields = fields;
    }

    public EmptyArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyArgumentException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString(){
        return "In field " + fields + " is empty";
    }
}
