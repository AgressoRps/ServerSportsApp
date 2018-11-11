package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.TrainingDayWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.TrainingDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/training-day")
public class TrainingDayController {

    private final TrainingDayService trainingDayService;

    @Autowired
    public TrainingDayController(TrainingDayService trainingDayService){
        this.trainingDayService = trainingDayService;
    }

    /**
     * Метод реагирует на запрос /training-day/, выполняет запрос к бд для получения списка всех существующих тренировчных дней
     * @return список экземпляров класса TrainingDayWrapper содержащих информацию о тренировочном дне
     * @throws ServerException в случае ошибки во время выполнения - генерация исключения
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TrainingDayWrapper> getTrainingDays() throws ServerException {
        return trainingDayService.getAllTrainingDays();
    }

    /**
     * Метод реагирует на запрос /training-day/{id}, выполняет запрос к бд для получения тренировочного
     * дня по переданному идентификатору
     * @param id идентификатор тренировочного дня
     * @return экземпляр класса TrainingDay (тренировочный день)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public TrainingDayWrapper getById(@PathVariable("id") Long id) throws ServerException{
        return trainingDayService.getById(id);
    }

    /**
     * Метод реагирует на запрос /training-day/training-program/{id}, выполняет запрос к бд для получения всех
     * тренировочных дней связанных с переданным идентификатором тренировочной программы
     * @param id идентификатор тренировочной программы
     * @return список экземпляров класса TrainingProgramWrapper (список тренировочных дней)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/training-program/{id}", method = RequestMethod.GET)
    public List<TrainingDayWrapper> getAllByTrainingProgramId(@PathVariable("id") Long id) throws ServerException{
        return trainingDayService.getAllByTrainingProgramId(id);
    }
}
