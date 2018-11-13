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

    /**
     * Метод добавления нового уровня сложности в базу данных
     * @param levelDifficultyWrapper данные уровня сложности, которые необходимо добавить
     * @return true - при успешном добавлении в бд
     * @throws ServerException генерирует исключение с кодом DATA_VALIDATE_ERROR либо LEVEL_DIFFICULTY_ADD_ERROR
     */
    public String addLevel(LevelDifficultyWrapper levelDifficultyWrapper) throws ServerException{
        try {
            if (levelDifficultyWrapper.getName() != null && levelDifficultyWrapper.getCoefficient() != null){
                LevelDifficulty levelDifficulty = new LevelDifficulty();
                levelDifficultyWrapper.fromWrapper(levelDifficulty);
                levelDifficultyRepository.save(levelDifficulty);
                return "true";
            }else {
                throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
            }
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.LEVEL_DIFFICULTY_ADD_ERROR), ex);
        }
    }

    /**
     * Метод редактирования уровня сложности
     * @param levelDifficultyWrapper уровень сложности с измененными данными
     * @return true - при успешном выполнении
     * @throws ServerException генерирует исключение с кодом LEVEL_DIFFICULTY_UPDATE_ERROR
     */
    public String editLevel(LevelDifficultyWrapper levelDifficultyWrapper) throws ServerException{
        try {
            LevelDifficulty levelDifficulty = getLevelDifficulty(levelDifficultyWrapper.getId());
            levelDifficultyWrapper.fromWrapper(levelDifficulty);
            levelDifficultyRepository.save(levelDifficulty);
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.LEVEL_DIFFICULTY_UPDATE_ERROR), ex);
        }
    }

    /**
     * Метод удаления уровня сложности из базы данных
     * @param levelDifficultyWrapper содержит идентификатор уровня сложности, по которому выполняется удаление
     * @return true - при успешном удалении из бд
     * @throws ServerException генерирует исключение с кодом LEVEL_DIFFICULTY_DELETE_ERROR
     */
    public String deleteLevel(LevelDifficultyWrapper levelDifficultyWrapper) throws ServerException{
        try {
            LevelDifficulty levelDifficulty = new LevelDifficulty();
            levelDifficultyWrapper.fromWrapper(levelDifficulty);
            levelDifficultyRepository.delete(levelDifficulty);
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.LEVEL_DIFFICULTY_DELETE_ERROR), ex);
        }
    }
}
