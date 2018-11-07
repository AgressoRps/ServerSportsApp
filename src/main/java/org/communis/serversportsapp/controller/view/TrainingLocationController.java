package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.TrainingLocationWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.TrainingLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/trainingLocation")
public class TrainingLocationController {

    private final TrainingLocationService trainingLocationService;

    @Autowired
    public TrainingLocationController(TrainingLocationService trainingLocationService){
        this.trainingLocationService = trainingLocationService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TrainingLocationWrapper> getAllTrainingLocations() throws ServerException{
        return trainingLocationService.getAllTrainingLocations();
    }

}
