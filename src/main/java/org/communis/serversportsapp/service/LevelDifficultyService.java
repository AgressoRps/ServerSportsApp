package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.LevelDifficultyWrapper;
import org.communis.serversportsapp.entity.LevelDifficulty;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.LevelDifficultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class LevelDifficultyService {

    private final LevelDifficultyRepository levelDifficultyRepository;

    @Autowired
    public LevelDifficultyService(LevelDifficultyRepository levelDifficultyRepository){
        this.levelDifficultyRepository = levelDifficultyRepository;
    }

    public List<LevelDifficultyWrapper> getAllLevelDifficulties() throws ServerException{
        try {
            return levelDifficultyRepository.findAll().stream().map(LevelDifficultyWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.LEVEL_DIFFICULTY_LIST_ERROR), ex);
        }
    }
}
