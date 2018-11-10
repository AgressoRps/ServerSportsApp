package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.ExerciseWrapper;
import org.communis.serversportsapp.entity.TrainingLocation;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.ExerciseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }

    /**
     * Метод реагирует на запрос /exercise/location/{id}, выполняет запрос к бд для получения списка всех
     * упражнений с указанной локацией
     * @param id идентификатор локации
     * @return список экземпляров ExerciseWrapper (упражнений)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    public List<ExerciseWrapper> getAllExercisesByTrainingLocation(@PathVariable("id") Short id) throws ServerException{
        return exerciseService.getAllExercisesByTrainingLocationId(id);
    }

    /**
     * Метод реагирует на запрос /exrcise/{id}, выполняет запрос к бд для получения единичного экземпляра упражнения
     * @param id идентификатор упражнения
     * @return экземпляр класса ExerciseWrapper содержащий данные о найденном в бд упражнении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ExerciseWrapper getById(@PathVariable("id") Short id) throws ServerException{
        return exerciseService.getById(id);
    }

}
