package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.TrainingLocationWrapper;
import org.communis.serversportsapp.entity.TrainingLocation;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.TrainingLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class TrainingLocationService {

    private final TrainingLocationRepository trainingLocationRepository;

    @Autowired
    public TrainingLocationService(TrainingLocationRepository trainingLocationRepository){
        this.trainingLocationRepository = trainingLocationRepository;
    }

    /**
     * Метод поиска и получения всех существующих тренировочных локаций
     * @return список экземпляров класса TrainingLocationWrapper (список локаций)
     * @throws ServerException генерирует исключение с кодом TRAINING_LOCATION_LIST_ERROR
     */
    public List<TrainingLocationWrapper> getAllTrainingLocations() throws ServerException{
        try{
            return trainingLocationRepository.findAll().stream().map(TrainingLocationWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_LOCATION_LIST_ERROR), ex);
        }
    }

    /**
     * Метод получения и поиска тренировочной локации по указанному идентификатору
     * @param id идентификатор тренировочной локации
     * @return экземпляр класса TrainingLocationWrapper (тренировочная локация)
     * @throws ServerException генерирует исключение с кодом TRAINING_LOCATION_INFO_ERROR
     */
    public TrainingLocationWrapper getById(Short id) throws ServerException{
        try{
            return new TrainingLocationWrapper(getTrainingLocation(id));
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_LOCATION_INFO_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения тренировочной локации по переданному идентификатору
     * @param id идентификатор тренировочной локации
     * @return экземпляр класса TrainingLocation (тренировочная локация)
     * @throws ServerException генерирует исключение с кодом DATA_NOT_FOUND
     */
    private TrainingLocation getTrainingLocation(Short id) throws ServerException{
        return trainingLocationRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }
}
