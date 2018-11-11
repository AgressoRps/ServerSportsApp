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
@RequestMapping("/training-day-content")
public class TrainingDayContentController {

    private final TrainingDayContentService trainingDayContentService;

    @Autowired
    public TrainingDayContentController(TrainingDayContentService trainingDayContentService){
        this.trainingDayContentService = trainingDayContentService;
    }

    /**
     * Метод реагирует на запрос /training-day-content/training-day/{id}, выполняет запрос к бд
     * для получения всех значений связанных с указанным тренировочным днем
     * @param id идентификатор тренировочного дня
     * @return список экземпляров класса TrainingDayContentWrapper (контент тренировки)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/training-day/{id}", method = RequestMethod.GET)
    public List<TrainingDayContentWrapper> getAllContentByTrainingDay(@PathVariable("id") Long id) throws ServerException{
        return trainingDayContentService.getAllContentByTrainingDay(id);
    }

    /**
     * Метод реагирует на запрос /training-day-content/{id}, выполняет запрос к бд для получения
     * всех данных связанных с переданным идентификатор контента тренировочного дня
     * @param id идентификатор контента тренировочного дня
     * @return экземпляр класса TrainingDayContentWrapper (контент тренировки)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TrainingDayContentWrapper getById(@PathVariable("id") Long id) throws ServerException{
        return trainingDayContentService.getById(id);
    }

    /**
     * Метод реагирует на запрос /training-day-content/, выполняет запрос к бд для получения всех
     * данных таблицы
     * @return список экземпляров класса TrainingDayContentWrapper (весь тренировочный контент бд)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TrainingDayContentWrapper> getAll() throws ServerException{
        return trainingDayContentService.getAll();
    }
}
