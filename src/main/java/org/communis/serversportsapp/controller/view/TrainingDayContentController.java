package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.TrainingDayContentWrapper;
import org.communis.serversportsapp.entity.TrainingDay;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.repository.TrainingDayContentRepository;
import org.communis.serversportsapp.service.TrainingDayContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.serial.SerialException;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/trainingDayContent")
public class TrainingDayContentController {

    private final TrainingDayContentService trainingDayContentService;

    @Autowired
    public TrainingDayContentController(TrainingDayContentService trainingDayContentService){
        this.trainingDayContentService = trainingDayContentService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<TrainingDayContentWrapper> getAllContentByTrainingDay(@PathVariable("id") Long id) throws ServerException{
        TrainingDay trainingDay = new TrainingDay();
        trainingDay.setId(id);
        return trainingDayContentService.getAllContentByTrainingDay(trainingDay);
    }
}
