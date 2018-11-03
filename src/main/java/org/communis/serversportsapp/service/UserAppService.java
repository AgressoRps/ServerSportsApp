package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.UserAppWrapper;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformation;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = ServerException.class)
public class UserAppService {

    private final UserAppRepository userAppRepository;

    @Autowired
    public UserAppService(UserAppRepository userAppRepository){
        this.userAppRepository = userAppRepository;
    }

    public UserAppWrapper getById(Long id) throws ServerException{
        try {
            return new UserAppWrapper(getUserApp(id));
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_INFO_ERROR), ex);
        }
    }

    private UserApp getUserApp(Long id) throws ServerException{
        return userAppRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }
}
