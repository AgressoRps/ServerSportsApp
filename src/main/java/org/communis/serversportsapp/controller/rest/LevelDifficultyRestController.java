package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.LevelDifficultyWrapper;
import org.communis.serversportsapp.entity.LevelDifficulty;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.LevelDifficultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/level")
public class LevelDifficultyRestController {

    private final LevelDifficultyService levelDifficultyService;

    @Autowired
    public LevelDifficultyRestController(LevelDifficultyService levelDifficultyService){
        this.levelDifficultyService = levelDifficultyService;
    }

    /**
     * Метод реагирует на запрос /level/add, выполняет запрос к бд
     * для добавления нового уровня сложности
     * @param levelDifficultyWrapper данные, которые необходимо добавить (уровень сложности)
     * @return true - при успешном добавлении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addLevel(LevelDifficultyWrapper levelDifficultyWrapper) throws ServerException{
        return levelDifficultyService.addLevel(levelDifficultyWrapper);
    }

    /**
     * Метод реагирует на запрос /level/edit, выполняет запрос к бд
     * для изменения уровня сложности
     * @param levelDifficultyWrapper данные, которые нужно заменить в указанном уровне сложности
     * @return true - в случае успешного выполнения
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    @ResponseBody
    public String editLevel(LevelDifficultyWrapper levelDifficultyWrapper) throws ServerException{
        return levelDifficultyService.editLevel(levelDifficultyWrapper);
    }

    /**
     * Метод реагирует на запрос /level/delete, выполняет запрос к бд
     * для удаления уровня сложности
     * @param levelDifficultyWrapper содержит идентификатор уровня сложности, который нужно удалить
     * @return true - в случае успешного удаления
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteLevel(LevelDifficultyWrapper levelDifficultyWrapper) throws ServerException{
        return levelDifficultyService.deleteLevel(levelDifficultyWrapper);
    }
}
