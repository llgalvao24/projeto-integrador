package org.generation.brazil.backend.exception.myexc;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String message){
        super(message);
    }

    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }

}
