package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.TrainingDayContentWrapper;
import org.communis.serversportsapp.entity.TrainingDay;
import org.communis.serversportsapp.entity.TrainingDayContent;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.TrainingDayContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class TrainingDayContentService {

    private final TrainingDayContentRepository trainingDayContentRepository;

    @Autowired
    public TrainingDayContentService(TrainingDayContentRepository trainingDayContentRepository){
        this.trainingDayContentRepository = trainingDayContentRepository;
    }

    /**
     * Метод поиска и получения всего контента тренировочного дня по идентификатору
     * @param id идентификатор тренировоного дня, содержимое которого необходимо получить
     * @return список экземпляров класса TrainingDayContent (содержимое тренировочного дня)
     * @throws ServerException генерирует исключение с кодом TRAINING_DAY_CONTENT_LIST_ERROR
     */
    public List<TrainingDayContentWrapper> getAllContentByTrainingDay(Long id) throws ServerException{
        try{
            return trainingDayContentRepository.findAllByTrainingDayID(id).stream().map(TrainingDayContentWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_CONTENT_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения всего контента тренировочных дней
     * @return список экземпляров класса TrainingDayContent (содержимое тренировочных дней)
     * @throws ServerException генерирует исключение с кодом TRAINING_DAY_CONTENT_LIST_ERROR
     */
    public List<TrainingDayContentWrapper> getAll() throws ServerException{
        try{
            return trainingDayContentRepository.findAll().stream().map(TrainingDayContentWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_CONTENT_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения данных содержимого тренировочного дня по переданному идентификатору
     * @param id идентификатор содержимого тренировочного дня
     * @return экземпляр класса TrainingDayContentWrapper (контент тренировочного дня)
     * @throws ServerException генерирует исключение с кодом TRAINING_DAY_CONTENT_INFO_ERROR
     */
    public TrainingDayContentWrapper getById(Long id) throws ServerException{
        try{
            return new TrainingDayContentWrapper(getTrainingDayContent(id));
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_CONTENT_INFO_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения данных содержимого тренировочного дня по идентификатору
     * @param id идентификатор тренировочного дня
     * @return экземпляр класса TrainingDayContent (контент тренировчного дня)
     * @throws ServerException генерирует исключение с кодом DATA_NOT_FOUND
     */
    private TrainingDayContent getTrainingDayContent(Long id) throws ServerException{
        return trainingDayContentRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

}
