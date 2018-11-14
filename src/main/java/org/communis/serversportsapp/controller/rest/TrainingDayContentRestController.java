package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.TrainingDayContentWrapper;
import org.communis.serversportsapp.entity.TrainingDayContent;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.TrainingDayContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/training-day-content")
public class TrainingDayContentRestController {

    private final TrainingDayContentService trainingDayContentService;

    @Autowired
    public TrainingDayContentRestController(TrainingDayContentService trainingDayContentService){
        this.trainingDayContentService = trainingDayContentService;
    }

    /**
     * Метод реагирует на запрос /training-day-content/add, выполняет запрос к бд
     * для добавления нового содержимого тренировочного дня
     * @param trainingDayContentWrapper содержимое тренировочного дня, которое необходимо добавить в бд
     * @return true - при успешном выполнении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addTrainingDayContent(TrainingDayContentWrapper trainingDayContentWrapper) throws ServerException{
        return trainingDayContentService.addTrainingDayContent(trainingDayContentWrapper);
    }

    /**
     * Метод реагирует на запрос /training-day-content/edit, выполняет запрос к бд
     * для редактирования содержимого тренировочного дня
     * @param trainingDayContentWrapper содержимое тренировочного дня с измененными данными
     * @return true - при успешном выполнении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    @ResponseBody
    public String editTrainingDayContent(TrainingDayContentWrapper trainingDayContentWrapper) throws ServerException{
        return trainingDayContentService.editTrainingDayContent(trainingDayContentWrapper);
    }

    /**
     * Метод реагирует на запрос /training-day-content/delete, выполняет запрос к бд
     * для удаления записи содержимого тренировочного дня
     * @param trainingDayContentWrapper содержимое тренировочного дня, содержит идентификатор по которому производится удаление записи
     * @return true - при успешном выполнении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTrainingDayContent(TrainingDayContentWrapper trainingDayContentWrapper) throws ServerException{
        return trainingDayContentService.deleteTrainingDayContent(trainingDayContentWrapper);
    }
}
