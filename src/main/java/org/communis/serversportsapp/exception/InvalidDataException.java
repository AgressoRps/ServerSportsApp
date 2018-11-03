package org.communis.serversportsapp.exception;

import org.communis.serversportsapp.exception.error.ErrorInformation;

public class InvalidDataException extends ServerException {

    public InvalidDataException(ErrorInformation errorInformation) {
        super(errorInformation);
    }

}
