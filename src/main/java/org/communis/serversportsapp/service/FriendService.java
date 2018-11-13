package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.FriendWrapper;
import org.communis.serversportsapp.entity.Friend;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.FriendRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class FriendService {

    private final FriendRepository friendRepository;

    @Autowired
    public FriendService(FriendRepository friendRepository){
        this.friendRepository = friendRepository;
    }

    /**
     * Метод поиска всех друзей указанного пользователя
     * @param id идентификатор пользователя
     * @return список экземпляров класса FriendWrapper (список друзей)
     * @throws ServerException генерирует исключение с кодом FRIEND_LIST_ERROR
     */
    public List<FriendWrapper> getAllFriendsUser(Long id) throws ServerException{
        try{
            return friendRepository.findAllByUserID(id).stream().map(FriendWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.FRIEND_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения данных по переданному идентификатору
     * @param id идентификатор запрашиваемой строки
     * @return экземпляр класса Friend (данные о друге)
     * @throws ServerException генерирует исключение с кодом DATA_NOT_FOUND
     */
    private Friend getFriend(Long id) throws ServerException{
        return friendRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

    public String addFriend(FriendWrapper friendWrapper) throws ServerException{
        try {
            if (friendWrapper.getUserID() != null && friendWrapper.getFriendWrapper().getId() != null){
                Friend friend = new Friend();
                friendWrapper.fromWrapper(friend);
                friendRepository.save(friend);
                return "true";
            }else {
                throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
            }
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.FRIEND_ADD_ERROR), ex);
        }
    }

}
