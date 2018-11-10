package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.LevelDifficultyWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.LevelDifficultyService;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/level")
public class LevelDifficultyController {

    private final LevelDifficultyService levelDifficultyService;

    @Autowired
    public LevelDifficultyController(LevelDifficultyService levelDifficultyService){
        this.levelDifficultyService = levelDifficultyService;
    }

    /**
     * Метод реагирует на запрос /level, выполняет запрос к бд для получения списка всех уровней сложности
     * @return список экземпляров класса LevelDifficultyWrapper (список уровней сложности)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<LevelDifficultyWrapper> getAllDifficulties() throws ServerException{
        return levelDifficultyService.getAllLevelDifficulties();
    }

    /**
     * Метод реагирует на запрос /level/{id}, выполняет запрос к бд для получения данных конкретного уровня сложности
     * @param id идентификатор уровня сложности
     * @return экземпляр класса LevelDifficultyWrapper (уровень сложности)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LevelDifficultyWrapper getById(@PathVariable("id") Short id) throws ServerException{
        return null; //TODO
    }
}
