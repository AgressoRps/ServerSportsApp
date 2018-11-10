package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.ProgressUserWrapper;
import org.communis.serversportsapp.dto.UserAppWrapper;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.ProgressUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class ProgressUserService {

    private final ProgressUserRepository progressUserRepository;

    @Autowired
    public ProgressUserService(ProgressUserRepository progressUserRepository){
        this.progressUserRepository = progressUserRepository;
    }

    /**
     * Метод получения всех достижений требуемого пользователя
     * @param id идентификатор пользователя, достижения которого необходимо получить
     * @return список экземпляров класса ProgressUserWrapper (список достижений пользователя)
     * @throws ServerException в случае ошибки генерирует исключение с кодом PROGRESS_USER_LIST_ERROR
     */
    public List<ProgressUserWrapper> getAllProgressUser(Long id) throws ServerException{
        try{
            return progressUserRepository.findAllByUserID(id).stream().map(ProgressUserWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.PROGRESS_USER_LIST_ERROR), ex);
        }
    }

}
