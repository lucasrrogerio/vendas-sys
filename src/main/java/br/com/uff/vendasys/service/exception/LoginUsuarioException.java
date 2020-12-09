package br.com.uff.vendasys.service.exception;

public class LoginUsuarioException extends RuntimeException {
    public LoginUsuarioException() {
        super();
    }

    public LoginUsuarioException(String message) {
        super(message);
    }

    public LoginUsuarioException(String message, Throwable cause) {
        super(message, cause);
    }
}
