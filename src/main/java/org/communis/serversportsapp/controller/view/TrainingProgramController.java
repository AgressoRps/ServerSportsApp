package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.TrainingProgramWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.TrainingProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/training-program")
public class TrainingProgramController {
    private final TrainingProgramService trainingProgramService;

    @Autowired
    public TrainingProgramController(TrainingProgramService trainingProgramService){
        this.trainingProgramService = trainingProgramService;
    }

    /**
     * Метод реагирует на запрос /training-program/, выполняет запрос к бд для
     * получения списка всех существующих программ
     * @return список экземпляров класса TrainingProgramWrapper (список тренировочных программ)
     * @throws ServerException в случае ошибки во время выполнения - генерация исключения
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TrainingProgramWrapper> getTrainingPrograms() throws ServerException {
        return trainingProgramService.getAllTrainingPrograms();
    }

    /**
     * Метод реагирует на зпрос /training-program/{id}, выполняет запрос к бд для получения данных
     * о запрашиваемой тренировочной программе по переданному идентификатору
     * @param id идентификатор тренировочной программы
     * @return экземпляр класса TrainingProgramWrapper (тренировочная программа)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TrainingProgramWrapper getById(@PathVariable("id") Long id) throws ServerException{
        return trainingProgramService.getById(id);
    }

    /**
     * Метод реагирует на запрос /training-program/user/{id}, выполняет запрос к бд для получения
     * всех тренировочных программ указанного пользователя
     * @param userId идентификатор пользователя
     * @return список экземпляров класса TrainingProgramWrapper (список тренировочных программ пользователя)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public List<TrainingProgramWrapper> getByUserId(@PathVariable("id") Long userId) throws ServerException{
        return trainingProgramService.getByUserId(userId);
    }

    /**
     * Метод реагирует на запрос /training-program/user/{userId}/location/{locationId}, выполняет запрос к бд
     * для получения списка всех тренировочных программ указанного пользователя на запрашиваемой локации
     * @param userId идентификатор пользователя
     * @param locationId идентификатор тренировочной программы
     * @return список экземпляров класса TrainingProgramWrapper (список тренировочных программ)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/user/{userId}/location/{locationId}", method = RequestMethod.GET)
    public List<TrainingProgramWrapper> getByUserIdAndTrainingLocationId(@PathVariable("userId") Long userId,
                                                                         @PathVariable("locationId") Short locationId) throws ServerException{
        return trainingProgramService.getByUserIdAndTrainingLocationId(userId, locationId);
    }
}
