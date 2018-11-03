package org.communis.serversportsapp.exception;

import org.communis.serversportsapp.exception.error.ErrorInformation;

public class NotFoundException extends ServerException {

    public NotFoundException(ErrorInformation errorInformation) {
        super(errorInformation);
    }

}
