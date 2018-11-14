package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.TrainingDayWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.TrainingDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/training-day")
public class TrainingDayRestController {

    private final TrainingDayService trainingDayService;

    @Autowired
    public TrainingDayRestController(TrainingDayService trainingDayService){
        this.trainingDayService = trainingDayService;
    }

    /**
     * Метод реагирует на запрос /training-day/add, выполняет запрос к бд
     * для добавления нового тренировочного дня
     * @param trainingDayWrapper содержит данные нового тренировочного дня
     * @return true - при успешном выполнении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addTrainingDay(TrainingDayWrapper trainingDayWrapper) throws ServerException{
        return trainingDayService.addTrainingDay(trainingDayWrapper);
    }

    /**
     * Метод реагирует на запрос /training-day/edit, выполняет запрос к бд
     * для обновления данных существующего тренировочного дня
     * @param trainingDayWrapper содержит обновленные данные тренировочного дня
     * @return true - при успешном выполнении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    @ResponseBody
    public String editTrainingDay(TrainingDayWrapper trainingDayWrapper) throws ServerException{
        return trainingDayService.editTrainingDay(trainingDayWrapper);
    }

    /**
     * Метод реагирует на запрос /training-day/delete, выполняет запрос к бд
     * для удаления существующего тренировочного дня по идентификатору
     * @param trainingDayWrapper содержит идентификатор тренировочного дня
     * @return true - при успешном удалении из бд
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTrainingDay(TrainingDayWrapper trainingDayWrapper) throws ServerException{
        return trainingDayService.deleteTrainingDay(trainingDayWrapper);
    }
}
