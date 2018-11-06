package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.TrainingDayWrapper;
import org.communis.serversportsapp.dto.TrainingProgramWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.TrainingDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class TrainingDayService {

    private final TrainingDayRepository trainingDayRepository;

    @Autowired
    public TrainingDayService(TrainingDayRepository trainingDayRepository){
        this.trainingDayRepository = trainingDayRepository;
    }
    
    public List<TrainingDayWrapper> getAllTrainingDays() throws ServerException{
        try {
            return trainingDayRepository.findAll().stream().map(TrainingDayWrapper::new).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_LIST_ERROR), ex);
        }
    }

}
