package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.TrainingDayWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.TrainingDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/trainingDay")
public class TrainingDayController {

    private final TrainingDayService trainingDayService;

    @Autowired
    public TrainingDayController(TrainingDayService trainingDayService){
        this.trainingDayService = trainingDayService;
    }

    /**
     * Метод получения списка всех существующих тренировчных дней
     * @return список экземпляров класса TrainingDayWrapper содержащих информацию о тренировочном дне
     * @throws ServerException в случае ошибки во время выполнения - генерация исключения
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TrainingDayWrapper> getTrainingDays() throws ServerException {
        return trainingDayService.getAllTrainingDays();
    }

}
