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

    /**
     * Метод поиска и получения списка всех уровней сложности
     * @return список экземпляров класса LevelDifficulty (уровней сложности)
     * @throws ServerException генерирует исключение с кодом LEVEL_DIFFICULTY_LIST_ERROR
     */
    public List<LevelDifficultyWrapper> getAllLevelDifficulties() throws ServerException{
        try {
            return levelDifficultyRepository.findAll().stream().map(LevelDifficultyWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.LEVEL_DIFFICULTY_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения уровня сложности
     * @param id идентификатор уровня сложности
     * @return экземпляр класса LevelDifficultyWrapper (уровень сложности)
     * @throws ServerException генерирует исключение с кодом LEVEL_DIFFICULTY_INFO_ERROR
     */
    public LevelDifficultyWrapper getById(Short id) throws ServerException{
        try {
            return new LevelDifficultyWrapper(getLevelDifficulty(id));
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.LEVEL_DIFFICULTY_INFO_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения уровня сложности
     * @param id идентификатор уровня сложности
     * @return экземпляр класса LevelDifficulty (уровень сложности)
     * @throws ServerException генерирует исключение с кодом DATA_NOT_FOUND
     */
    private LevelDifficulty getLevelDifficulty(Short id) throws ServerException{
        return levelDifficultyRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }
}
