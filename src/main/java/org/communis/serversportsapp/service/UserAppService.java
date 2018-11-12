package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.UserAppWrapper;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.enums.UserAppRole;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformation;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class UserAppService {

    private final UserAppRepository userAppRepository;

    @Autowired
    public UserAppService(UserAppRepository userAppRepository){
        this.userAppRepository = userAppRepository;
    }

    /**
     * Метод поиска и получения всех пользователей с указанной ролью
     * @param role роль пользователя
     * @return список экземпляров класса UserAppWrapper (список пользователей)
     * @throws ServerException генерирует исключение с кодом USER_LIST_ERROR
     */
    public List<UserAppWrapper> getByRole(String role) throws ServerException{
        try {
            return userAppRepository.findAllByRole(UserAppRole.valueOf(role)).stream().map(UserAppWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения списка пользователей по переданному имени либо логину
     * @param name имя пользователя
     * @param login логин пользователя
     * @return список экземпляров класса UserAppWrapper (список пользователей соответствующих переданному имени либо логину)
     * @throws ServerException генерирует исключение с кодом USER_LIST_ERROR
     */
    public List<UserAppWrapper> getByNameLikeOrLoginLike(String name, String login) throws ServerException{
        try {
            return userAppRepository.findAllByNameLikeOrLoginLike(name, login).stream().map(UserAppWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения данных пользователя по переданной электронной почте
     * @param email электронная почта
     * @return экземпляр класса UserAppWrapper (пользователь)
     * @throws ServerException генерирует исключения с кодами DATA_NOT_FOUND и USER_INFO_ERROR
     */
    public UserAppWrapper getByEmail(String email) throws ServerException{
        UserApp userApp = new UserApp();
        try {
            userApp = userAppRepository.findByEmail(email)
                    .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
            return new UserAppWrapper(userApp);
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_INFO_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения данных пользователя по переданному идентификатору
     * @param login идентификатор пользователя
     * @return экземпляр класса UserAppWrapper (пользователь)
     * @throws ServerException генерирует исключение с кодами DATA_NOT_FOUND и USER_INFO_ERROR
     */
    public UserAppWrapper getByLogin(String login) throws ServerException{
        UserApp userApp = new UserApp();
        try{
            userApp = userAppRepository.findByLogin(login)
                    .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
            return new UserAppWrapper(userApp);
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_INFO_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения данных пользователя по указанному логину либо электронной почте
     * @param login логин пользователя
     * @param email электронная почта пользователя
     * @return экземпляр класса UserAppWrapper (пользователь)
     * @throws ServerException генерирует исключения с кодами DATA_NOT_FOUND и USER_INFO_ERROR
     */
    public UserAppWrapper getByLoginOrEmail(String login, String email) throws ServerException{
        UserApp userApp = new UserApp();
        try{
            userApp = userAppRepository.findByLoginOrEmail(login, email)
                    .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
            return new UserAppWrapper(userApp);
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_INFO_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения данных пользователя по переданному идентификатору
     * @param id идентификатор пользователя
     * @return экземпляр класса UserAppWrapper (пользователь)
     * @throws ServerException генерирует исключение с кодом USER_INFO_ERROR
     */
    public UserAppWrapper getById(Long id) throws ServerException{
        try {
            return new UserAppWrapper(getUserApp(id));
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_INFO_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения данных пользователя по переданному идентификатору
     * @param id идентификатор пользователя
     * @return экземпляр класса UserApp (пользователь)
     * @throws ServerException генерирует исключение с кодом DATA_NOT_FOUND
     */
    private UserApp getUserApp(Long id) throws ServerException{
        return userAppRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }
}
