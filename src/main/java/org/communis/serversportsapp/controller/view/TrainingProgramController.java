package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.TrainingProgramWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.TrainingProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/trainingProgram")
public class TrainingProgramController {
    private final TrainingProgramService trainingProgramService;

    @Autowired
    public TrainingProgramController(TrainingProgramService trainingProgramService){
        this.trainingProgramService = trainingProgramService;
    }

    /**
     * Метод получения списка всех существующих программ
     * @return список экземпляров класса TrainingProgramWrapper содержащих информацию о программе
     * @throws ServerException в случае ошибки во время выполнения - генерация исключения
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TrainingProgramWrapper> getTrainingPrograms() throws ServerException {
        return trainingProgramService.getAllTrainingPrograms();
    }
}
