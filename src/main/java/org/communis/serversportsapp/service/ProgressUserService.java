package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.ProgressUserWrapper;
import org.communis.serversportsapp.dto.UserAppWrapper;
import org.communis.serversportsapp.entity.ProgressUser;
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

    /**
     * Метод получения достижения по идентификатору записи
     * @param id идентификатор достижения пользователя
     * @return экземпляр класса ProgressUser (достижение пользователя)
     * @throws ServerException генерирует исключение с кодом DATA_NOT_FOUND
     */
    private ProgressUser getProgressUser(Long id) throws ServerException{
        return progressUserRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

    /**
     * Метод добавления нового достижения пользователю
     * @param progressUserWrapper связанные данные Пользователь - Достижение
     * @return true - при успешном добавлении достижения пользователю
     * @throws ServerException
     */
    public String addProgressUser(ProgressUserWrapper progressUserWrapper) throws ServerException{
        try {
            if (progressUserWrapper.getUserID() != null && progressUserWrapper.getProgressWrapper().getId() != null){
                ProgressUser progressUser = new ProgressUser();
                progressUserWrapper.fromWrapper(progressUser);
                if (checkProgressUser(getAllProgressUser(progressUserWrapper.getUserID()), progressUserWrapper.getProgressWrapper().getId())){
                    progressUserRepository.save(progressUser);
                    return "true";
                }else {
                    throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.PROGRESS_USER_EXIST_ERROR));
                }
            }else {
                throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
            }
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.PROGRESS_USER_ADD_ERROR), ex);
        }
    }

    /**
     * Метод удаления достижения пользователя
     * @param progressUserWrapper содержит идентификатор связывающей записи, которую необходимо удалить
     * @return true - при успешном удалении
     * @throws ServerException генерирует исключение с кодом PROGRESS_USER_DELETE_ERROR
     */
    public String deleteProgressUser(ProgressUserWrapper progressUserWrapper) throws ServerException{
        try {
            progressUserRepository.delete(progressUserWrapper.getUserID());
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.PROGRESS_USER_DELETE_ERROR), ex);
        }
    }

    /**
     * Метод поиска совпадения на существование заданного достижения у пользователя
     * @param progressUserWrappers список достижений пользователя
     * @param progressUserId идентификатор добавляемого достижения
     * @return true - если совпадений не найдено
     * false - если такое достижение уже существует
     */
    private Boolean checkProgressUser(List<ProgressUserWrapper> progressUserWrappers, Short progressUserId){
        for (ProgressUserWrapper progressUser : progressUserWrappers){
            if (progressUser.getProgressWrapper().getId().equals(progressUserId)){
                return false;
            }
        }
        return true;
    }
}
