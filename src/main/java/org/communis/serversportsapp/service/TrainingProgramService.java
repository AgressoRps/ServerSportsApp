package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.TrainingProgramWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.TrainingProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class TrainingProgramService {

    private final TrainingProgramRepository trainingProgramRepository;

    @Autowired
    public TrainingProgramService(TrainingProgramRepository trainingProgramRepository){
        this.trainingProgramRepository = trainingProgramRepository;
    }

    public List<TrainingProgramWrapper> getAllTrainingPrograms() throws ServerException{
        try {
            return trainingProgramRepository.findAll().stream().map(TrainingProgramWrapper::new).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_PROGRAM_LIST_ERROR), ex);
        }
    }
}
