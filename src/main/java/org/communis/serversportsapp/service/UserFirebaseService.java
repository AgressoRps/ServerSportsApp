package org.communis.serversportsapp.service;

import org.apache.catalina.Server;
import org.communis.serversportsapp.dto.UserFirebaseWrapper;
import org.communis.serversportsapp.entity.UserFirebase;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformation;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.UserFirebaseRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class UserFirebaseService {

    private final UserFirebaseRepository userFirebaseRepository;

    @Autowired
    public UserFirebaseService(UserFirebaseRepository userFirebaseRepository){
        this.userFirebaseRepository = userFirebaseRepository;
    }

    public UserFirebaseWrapper getUserById(Long id) throws ServerException{
        try {
            return new UserFirebaseWrapper(getUserFirebase(id));
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_INFO_ERROR), ex);
        }
    }

    private UserFirebase getUserFirebase(Long id) throws ServerException{
        return userFirebaseRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

    public UserFirebaseWrapper getUserByUid(String uid) throws ServerException{
        try {
            return new UserFirebaseWrapper(getUserFirebaseByUid(uid));
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_INFO_ERROR), ex);
        }
    }

    private UserFirebase getUserFirebaseByUid(String uid) throws ServerException{
        return userFirebaseRepository.findByUid(uid)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

    public List<UserFirebaseWrapper> getAllUsers() throws ServerException{
        try {
            return userFirebaseRepository.findAll().stream().map(UserFirebaseWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_LIST_ERROR), ex);
        }
    }

    public String addUser(UserFirebaseWrapper userFirebaseWrapper) throws ServerException{
        try {
            if (userFirebaseWrapper.getUid() != null){
                //if (checkUserFirebase(userFirebaseRepository.))
                UserFirebase userFirebase = getUserFirebaseByUid(userFirebaseWrapper.getUid());
                if (userFirebase.getId() == null && userFirebase.getUid() == null){
                    UserFirebase addUser = new UserFirebase();
                    userFirebaseWrapper.fromWrapper(addUser);
                    userFirebaseRepository.save(userFirebase);
                    return "true";
                }else {
                    throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_LOGIN_ALREADY_EXIST));
                }
            }else {
                throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
            }
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_ADD_ERROR), ex);
        }
    }

    /*private boolean checkUserFirebase(List<UserFirebaseWrapper> userFirebaseWrappers, String uid){
        for (UserFirebaseWrapper userFirebaseWrapper : userFirebaseWrappers){
            if (userFirebaseWrapper.getUid().equals(uid)){
                return false;
            }
        }
        return true;
    }*/
}
