package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.TrainingLocationWrapper;
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

    public List<TrainingLocationWrapper> getAllTrainingLocations() throws ServerException{
        try{
            return trainingLocationRepository.findAll().stream().map(TrainingLocationWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_LOCATION_LIST_ERROR), ex);
        }
    }
}
