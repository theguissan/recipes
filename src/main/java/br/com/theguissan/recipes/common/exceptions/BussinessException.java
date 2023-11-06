package br.com.theguissan.recipes.common.exceptions;

public class BussinessException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public BussinessException() {}
    
    public BussinessException(final String message) {
        super(message);
    }
    
    public BussinessException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    public BussinessException(final Throwable cause) {
        super(cause);
    }
    
}
