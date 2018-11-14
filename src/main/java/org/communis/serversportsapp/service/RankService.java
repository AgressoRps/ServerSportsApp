package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.RankWrapper;
import org.communis.serversportsapp.entity.Rank;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class RankService {

    private final RankRepository rankRepository;

    @Autowired
    public RankService(RankRepository rankRepository){
        this.rankRepository = rankRepository;
    }

    /**
     * Метод поиска и получения всех существующих в бд званий
     * @return список экземпляров класса RankWrapper (список всех званий)
     * @throws ServerException генерирует исключение с кодом RANK_LIST_ERROR
     */
    public List<RankWrapper> getAllRanks() throws ServerException{
        try {
            return rankRepository.findAll().stream().map(RankWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.RANK_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения звания по указанному идентификатору
     * @param id идентификатор требуемого звания
     * @return экземпляр класса RankWrapper (звание)
     * @throws ServerException генерирует исключение с кодом RANK_INFO_ERROR
     */
    public RankWrapper getById(Short id) throws ServerException{
        try {
            return new RankWrapper(getRank(id));
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.RANK_INFO_ERROR), ex);
        }
    }

    /**
     * Метод получения всех данных о звании по идентификатору
     * @param id идентификатор требуемого звания
     * @return экземпляр класса Rank (звание)
     * @throws ServerException генерирует исключение с кодом DATA_NOT_FOUND
     */
    private Rank getRank(Short id) throws ServerException{
        return rankRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

    /**
     * Метод добавления нового звания
     * @param rankWrapper содержит данные, которые необходимо добавить
     * @return true - при успешном добавлении
     * @throws ServerException генерирует исключение с кодом DATA_VALIDATE_ERROR либо RANK_ADD_ERROR
     */
    public String addRank(RankWrapper rankWrapper) throws ServerException{
        try {
            if (rankWrapper.getName() != null && !rankWrapper.getName().equals("")){
                Rank rank = new Rank();
                rankWrapper.fromWrapper(rank);
                rankRepository.save(rank);
                return "true";
            }else {
                throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
            }
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.RANK_ADD_ERROR), ex);
        }
    }

    /**
     * Метод обновления данных звания (редактирования)
     * @param rankWrapper содержит измененные данные
     * @return true - при успешном обновлении данных
     * @throws ServerException генерирует исключение с кодом RANK_UPDATE_ERROR
     */
    public String editRank(RankWrapper rankWrapper) throws ServerException{
        try {
            Rank rank = getRank(rankWrapper.getId());
            rankWrapper.fromWrapper(rank);
            rankRepository.save(rank);
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.RANK_UPDATE_ERROR), ex);
        }
    }

    /**
     * Метод удаления звания из базы данных
     * @param rankWrapper содержит идентификатор удаляемого звания
     * @return true - при успешном удалении
     * @throws ServerException генерирует исключение с кодом RANK_DELETE_ERROR
     */
    public String deleteRank(RankWrapper rankWrapper) throws ServerException{
        try {
            Rank rank = new Rank();
            rankWrapper.fromWrapper(rank);
            rankRepository.save(rank);
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.RANK_DELETE_ERROR), ex);
        }
    }
}
