package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.TrainingLocationWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.TrainingLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/training-location")
public class TrainingLocationController {

    private final TrainingLocationService trainingLocationService;

    @Autowired
    public TrainingLocationController(TrainingLocationService trainingLocationService){
        this.trainingLocationService = trainingLocationService;
    }

    /**
     * Метод реагирует на запрос /training-location/, выполняет запрос к бд для поиска и получения
     * списка всех существующих локаций
     * @return список экземпляров класса TrainingLocationWrapper (список тренировочных локаций)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TrainingLocationWrapper> getAllTrainingLocations() throws ServerException{
        return trainingLocationService.getAllTrainingLocations();
    }

    /**
     * Метод реагирует на запрос /training-location/{id}, выполняет запрос к бд для поиска и получения
     * одной тренировочной локации по переданному идентификатору
     * @param id идентификатор тренировочной локации
     * @return экземпляр класса TrainingLocationWrapper (тренировочная локация)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public TrainingLocationWrapper getById(@PathVariable("id") Short id) throws ServerException{
        return trainingLocationService.getById(id);
    }

}
