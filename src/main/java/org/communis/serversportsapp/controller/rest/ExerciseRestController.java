package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.ExerciseWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/exercise")
public class ExerciseRestController {

    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseRestController(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }

    /**
     * Метод реагирует на запрос /exercise/addExercise, выполняет запрос к бд
     * для добавления нового упражнения в бд
     * @param exerciseWrapper данные, которые необходимо добавить в бд (упражнение)
     * @return true - в случае успешного добавления
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addExercise(ExerciseWrapper exerciseWrapper) throws ServerException{
        return exerciseService.addExercise(exerciseWrapper);
    }

    /**
     * Метод реагирует на запрос /exercise/editExercise, выполняет запрос к бд
     * для редактирования данных упражнения в бд
     * @param exerciseWrapper новые данные упражнения
     * @return true - в случае успешного редактирования
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    @ResponseBody
    public String editExercise(ExerciseWrapper exerciseWrapper) throws ServerException{
        return exerciseService.editExercise(exerciseWrapper);
    }

    /**
     * Метод реагирует на запрос /exercise/deleteExercise, выполняет запрос к бд
     * для удаления упражнения по переданному идентификатору
     * @param exerciseWrapper содержит идентификатор удаляемого упражнения
     * @return true - в случае успешного удаления
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteExercise(ExerciseWrapper exerciseWrapper) throws ServerException{
        return exerciseService.deleteExercise(exerciseWrapper);
    }
}
