package org.communis.serversportsapp.exception;

import org.communis.serversportsapp.exception.error.ErrorInformation;

public class AlreadyExistsException extends ServerException {
    public AlreadyExistsException(ErrorInformation errorInformation)
    {
        super(errorInformation);
    }
}
