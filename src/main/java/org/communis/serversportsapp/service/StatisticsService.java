package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.StatisticsWrapper;
import org.communis.serversportsapp.entity.Statistics;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepository){
        this.statisticsRepository = statisticsRepository;
    }

    /**
     * Метод поиска и получения всей статистики указанного пользователя
     * @param id идентификатор пользователя, статистику которого необходимо получить
     * @return список экземпляров класса StatisticsWrapper (список всей статистики пользователя)
     * @throws ServerException в случае ошибки генерирует исключение с кодом STATISTICS_LIST_ERROR
     */
    public List<StatisticsWrapper> getAllStatisticsByUser(Long id) throws ServerException{
        try {
            return statisticsRepository.findAllByUserID(id).stream().map(StatisticsWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.STATISTICS_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения статистики по идентификатору пользователя и программы
     * @param userID идентификатор пользователя
     * @param programID идентификатор тренировочной программы
     * @return список экземпляров класса StatisticsWrapper (список статистик)
     * @throws ServerException генерирует исключение с кодом STATISTICS_LIST_ERROR
     */
    public List<StatisticsWrapper> getByUserIdAndProgramId(Long userID, Long programID) throws ServerException{
        try {
            return statisticsRepository.findAllByUserIDAndTrainingProgramID(userID, programID).stream().map(StatisticsWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.STATISTICS_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения статистики по идентификатору пользователя и локации
     * @param userID идентификатор пользователя
     * @param locationID идентификатор требуемой локации
     * @return список экземпляров класса StatisticsWrapper (список статистики)
     * @throws ServerException генерирует исключение с кодом STATISTICS_LIST_ERROR
     */
    public List<StatisticsWrapper> getByUserIdAndLocationId(Long userID, Short locationID) throws ServerException{
        try {
            return statisticsRepository.findAllByUserIDAndTrainingLocationID(userID, locationID).stream().map(StatisticsWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.STATISTICS_LIST_ERROR), ex);
        }
    }

    /**
     * Метод получения статистики по идентификатору пользователя и тренировочного дня
     * @param userID идентификатор пользователя
     * @param trainingDayID идентификатор тренировочного дня
     * @return экземпляр класса StatisticsWrapper (статистика за указанный тренировочный день)
     * @throws ServerException генерирует исключение с кодом STATISTICS_INFO_ERROR
     */
    public StatisticsWrapper getByUserIdAndDayId(Long userID, Long trainingDayID) throws ServerException{
        try{
            return new StatisticsWrapper(getStatisticsByUserIdAndDayId(userID, trainingDayID));
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.STATISTICS_INFO_ERROR), ex);
        }
    }

    /**
     * Метод получения подробной статистики пользователя по указанному идентификатору
     * @param id идентификатор запрашиваемой статистики
     * @return экземпляр класса StatisticsWrapper (подробная статистика)
     * @throws ServerException генерирует исключение с кодом STATISTICS_INFO_ERROR
     */
    public StatisticsWrapper getById(Long id) throws ServerException{
        try {
            return new StatisticsWrapper(getStatistics(id));
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.STATISTICS_INFO_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения статистики по переданному идентификатору пользователя и тренировочного дня
     * @param userID идентификатор пользователя
     * @param trainingDayID идентификатор тренировочного дня
     * @return экземпляр класса Statistics (статистика указанного тренировочного дня)
     * @throws ServerException генерирует исключение с кодом DATA_NOT_FOUND
     */
    private Statistics getStatisticsByUserIdAndDayId(Long userID, Long trainingDayID) throws ServerException{
        return statisticsRepository.findFirstByUserIDAndTrainingDayID(userID, trainingDayID)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

    /**
     * Метод поиска и получения статистики по переданному идентификатору
     * @param id идентификатор статистики
     * @return экземпляр класса Statistics (подробная статистика пользователя)
     * @throws ServerException генерирует исключение с кодом DATA_NOT_FOUND
     */
    private Statistics getStatistics(Long id) throws ServerException{
        return statisticsRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }
}
