package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.RankUserWrapper;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.RankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class RankUserService {

    private final RankUserRepository rankUserRepository;

    @Autowired
    public RankUserService(RankUserRepository rankUserRepository){
        this.rankUserRepository = rankUserRepository;
    }

    /**
     * Метод получения всех званий указанного пользователя
     * @param id идентификатор пользователя
     * @return список экземпляров объекта RankUserWrapper (список всех званий)
     * @throws ServerException в случае ошибки генерирует исключение с кодом RANK_USER_LIST_ERROR
     */
    public List<RankUserWrapper> getAllRanksUser(Long id) throws ServerException{
        try {
            return rankUserRepository.findAllByUserID(id).stream().map(RankUserWrapper::new).collect(Collectors.toList());
        } catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.RANK_USER_LIST_ERROR), ex);
        }
    }

}
