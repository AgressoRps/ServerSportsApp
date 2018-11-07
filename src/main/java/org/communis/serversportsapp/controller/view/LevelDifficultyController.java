package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.LevelDifficultyWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.LevelDifficultyService;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/levelDifficulty")
public class LevelDifficultyController {

    private final LevelDifficultyService levelDifficultyService;

    @Autowired
    public LevelDifficultyController(LevelDifficultyService levelDifficultyService){
        this.levelDifficultyService = levelDifficultyService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<LevelDifficultyWrapper> getAllDifficulties() throws ServerException{
        return levelDifficultyService.getAllLevelDifficulties();
    }
}
