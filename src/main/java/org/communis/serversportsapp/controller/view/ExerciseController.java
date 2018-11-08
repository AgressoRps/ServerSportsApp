package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.ExerciseWrapper;
import org.communis.serversportsapp.entity.TrainingLocation;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.ExerciseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<ExerciseWrapper> getAllExercisesByTrainingLocation(@PathVariable("id") Short id) throws ServerException{
        TrainingLocation trainingLocation = new TrainingLocation();
        trainingLocation.setId(id);
        return exerciseService.getAllExercisesByTrainingLocation(trainingLocation);
    }

}
