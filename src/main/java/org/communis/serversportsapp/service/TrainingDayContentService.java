package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.TrainingDayContentWrapper;
import org.communis.serversportsapp.entity.TrainingDay;
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

    public List<TrainingDayContentWrapper> getAllContentByTrainingDay(TrainingDay trainingDay) throws ServerException{
        try{
            return trainingDayContentRepository.findAllByTrainingDay(trainingDay).stream().map(TrainingDayContentWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_CONTENT_LIST_ERROR), ex);
        }
    }

}
