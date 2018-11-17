package org.communis.serversportsapp.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.exception.AlreadyExistsException;
import org.communis.serversportsapp.exception.InvalidDataException;
import org.communis.serversportsapp.exception.NotFoundException;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@Log4j2
@RestControllerAdvice(basePackages = {
        "org.communis.serversportsapp.controller.rest"
})
public class ExceptionRestController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String notFoundHandler(NotFoundException ex) {
        return ex.getFriendlyMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidDataException.class)
    public String invalidDataHandler(InvalidDataException ex) {
        return ex.getFriendlyMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServerException.class)
    public String errorHandler(ServerException ex) {
        log.error(ex.getFriendlyMessage(), ex);
        return ex.getFriendlyMessage();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public String forbiddenHandler(AccessDeniedException ex) {
        log.error(ex.getMessage(), ex);
        return ErrorCodeConstants.messages.get(ErrorCodeConstants.ACCESS_ERROR);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AlreadyExistsException.class)
    public String notFoundHandler(AlreadyExistsException ex) {
        return ex.getFriendlyMessage();
    }

}
