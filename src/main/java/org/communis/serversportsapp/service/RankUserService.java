package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.RankUserWrapper;
import org.communis.serversportsapp.entity.Rank;
import org.communis.serversportsapp.entity.RankUser;
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

    /**
     * Метод добавления нового звания пользователю
     * @param rankUserWrapper содержит данные, необходимые для добавления звания
     * @return true - при успешном добавлении
     * @throws ServerException генерирует исключение с кодом RANK_USER_EXIST_ERROR либо DATA_VALIDATE_ERROR либо RANK_USER_ADD_ERROR
     */
    public String addRankUser(RankUserWrapper rankUserWrapper) throws ServerException{
        try {
            if (rankUserWrapper.getUserID() != null && rankUserWrapper.getRankWrapper().getId() != null){
                RankUser rankUser = new RankUser();
                rankUserWrapper.fromWrapper(rankUser);
                if (checkRankUser(getAllRanksUser(rankUserWrapper.getUserID()), rankUserWrapper.getRankWrapper().getId())){
                    rankUserRepository.save(rankUser);
                    return "true";
                }else {
                    throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.RANK_USER_EXIST_ERROR));
                }
            }else {
                throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
            }
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.RANK_USER_ADD_ERROR), ex);
        }
    }

    /**
     * Метод удаления звания пользователя из базы данных
     * @param rankUserWrapper содержит идентификатор удаляемой записи
     * @return true - при успешном удалении звания
     * @throws ServerException генерирует исключение с кодом RANK_USER_DELETE_ERROR
     */
    public String deleteRankUser(RankUserWrapper rankUserWrapper) throws ServerException{
        try {
            rankUserRepository.delete(rankUserWrapper.getId());
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.RANK_USER_DELETE_ERROR), ex);
        }
    }

    /**
     * Метод получения данных о звании пользователя по переданному идентификатору
     * @param id идентификатор записи, которую необходимо получить
     * @return экземпляр класса RankUser (звание пользователя)
     * @throws ServerException генерирует исключение с кодом DATA_NOT_FOUND
     */
    private RankUser getRankUser(Long id) throws ServerException{
        return rankUserRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

    /**
     * Метод сравнения и проверки, существует ли у указанного пользователя такое звание
     * @param rankUserWrappers список всех званий пользователя
     * @param rankID идентификатор звания, которое нужно найти
     * @return true - если у пользователя отсутствует заданное звание
     * false - если у пользователя уже есть такое звание
     */
    private Boolean checkRankUser(List<RankUserWrapper> rankUserWrappers, Short rankID){
        for (RankUserWrapper rankUser : rankUserWrappers){
            if (rankUser.getRankWrapper().getId().equals(rankID)){
                return false;
            }
        }
        return true;
    }
}
