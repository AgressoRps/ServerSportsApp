package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.TrainingProgramWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.TrainingProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/training-program")
public class TrainingProgramRestController {

    private final TrainingProgramService trainingProgramService;

    @Autowired
    public TrainingProgramRestController(TrainingProgramService trainingProgramService){
        this.trainingProgramService = trainingProgramService;
    }

    /**
     * Метод реагирует на запрос /training-program/add, выполняет запрос к бд
     * для добавления новой тренировочной программы
     * @param trainingProgramWrapper содержит добавляемые данные (тренировочную программу)
     * @return true - при успешном добавлении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addTrainingProgram(TrainingProgramWrapper trainingProgramWrapper) throws ServerException{
        return trainingProgramService.addTrainingProgram(trainingProgramWrapper);
    }

    /**
     * Метод реагирует на запрос /training-program/edit, выполняет запрос к бд
     * для обновления данных существующей тренировочной программы
     * @param trainingProgramWrapper содержит обновленные данные
     * @return true - при успешном обновлении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    @ResponseBody
    public String editTrainingProgram(TrainingProgramWrapper trainingProgramWrapper) throws ServerException{
        return trainingProgramService.editTrainingProgram(trainingProgramWrapper);
    }

    /**
     * Метод реагирует на запрос /training-program/delete, выполняет запрос к бд
     * для удаления существующей тренировочной программы
     * @param trainingProgramWrapper содержит идентификатор удаляемой тренировочной программы
     * @return true - при успешном удалении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTrainingProgram(TrainingProgramWrapper trainingProgramWrapper) throws ServerException{
        return trainingProgramService.deleteTrainingProgram(trainingProgramWrapper);
    }
}
