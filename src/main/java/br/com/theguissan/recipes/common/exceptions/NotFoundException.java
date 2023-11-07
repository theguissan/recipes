package br.com.theguissan.recipes.common.exceptions;

public class NotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    public NotFoundException() {}
    
    public NotFoundException(final String message) {
        super(message);
    }
    
    public NotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    public NotFoundException(final Throwable cause) {
        super(cause);
    }
    
    public static void lancarSe(final boolean eParaLancar, final String mensagem) {
        
        if (eParaLancar) {
            
            throw new NotFoundException(mensagem);
        }
    }
    
}
