package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.TrainingLocationWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.TrainingLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/training-location")
public class TrainingLocationRestController {

    private final TrainingLocationService trainingLocationService;

    @Autowired
    public TrainingLocationRestController(TrainingLocationService trainingLocationService){
        this.trainingLocationService = trainingLocationService;
    }

    /**
     * Метод реагирует на запрос /training-location/add, выполняет запрос к бд
     * для добавления новой тренировочной локации
     * @param trainingLocationWrapper содержит добавляемую информацию
     * @return true - при успешном добавлении в бд
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addTrainingLocation(TrainingLocationWrapper trainingLocationWrapper) throws ServerException{
        return trainingLocationService.addTrainingLocation(trainingLocationWrapper);
    }

    /**
     * Метод реагирует на запрос /training-location/edit, выполняет запрос к бд
     * для обновления информации о существующей локации
     * @param trainingLocationWrapper содержит данные, которыми будет обновлена запись
     * @return true - при успешном обновлении данных
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    @ResponseBody
    public String editTrainingLocation(TrainingLocationWrapper trainingLocationWrapper) throws ServerException{
        return trainingLocationService.editTrainingLocation(trainingLocationWrapper);
    }

    /**
     * Метод реагирует на запрос /training-location/delete, выполняет запрос к бд
     * для удаления тренировочной локации
     * @param trainingLocationWrapper содержит идентификатор удаляемой тренировочной локации
     * @return true - при успешном удалении из бд
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTrainingLocation(TrainingLocationWrapper trainingLocationWrapper) throws ServerException{
        return trainingLocationService.deleteTrainingLocation(trainingLocationWrapper);
    }
}
