package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.TrainingDayWrapper;
import org.communis.serversportsapp.dto.TrainingProgramWrapper;
import org.communis.serversportsapp.entity.TrainingDay;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.TrainingDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class TrainingDayService {

    private final TrainingDayRepository trainingDayRepository;

    @Autowired
    public TrainingDayService(TrainingDayRepository trainingDayRepository){
        this.trainingDayRepository = trainingDayRepository;
    }

    /**
     * Метод получения списка всех существующих тренировочных дней
     * @return список экземпляров класса TrainingDayWrapper (список всех тренировочных дней)
     * @throws ServerException генерирует исключение с кодом TRAINING_DAY_LIST_ERROR
     */
    public List<TrainingDayWrapper> getAllTrainingDays() throws ServerException{
        try {
            return trainingDayRepository.findAll().stream().map(TrainingDayWrapper::new).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_LIST_ERROR), ex);
        }
    }

    /**
     * Метод получения списка тренировочных дней связанных с указанной тренировочной программой
     * @param id идентификатор тренировочной программы
     * @return список экземпляров класса TrainingDayWrapper (список тренировочных дней)
     * @throws ServerException генерирует исключение с кодом TRAINING_DAY_LIST_ERROR
     */
    public List<TrainingDayWrapper> getAllByTrainingProgramId(Long id) throws ServerException{
        try{
            return trainingDayRepository.findAllByTrainingProgramID(id).stream().map(TrainingDayWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_LIST_ERROR), ex);
        }
    }

    /**
     * Метод получения тренировочного дня по переданному идентификатору
     * @param id идентификатор тренировочного дня
     * @return экземпляр класса TrainingDayWrapper (тренировочный день)
     * @throws ServerException
     */
    public TrainingDayWrapper getById(Long id) throws ServerException{
        try{
            return new TrainingDayWrapper(getTrainingDay(id));
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_INFO_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения тренировочного дня по переданному идентификатору
     * @param id идентификатор тренировочного дня
     * @return экземпляр класса TrainingDay (тренировочный день)
     * @throws ServerException генерирует исключение DATA_NOT_FOUND
     */
    private TrainingDay getTrainingDay(Long id) throws ServerException{
        return trainingDayRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

}
