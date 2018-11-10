package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.ExerciseWrapper;
import org.communis.serversportsapp.entity.Exercise;
import org.communis.serversportsapp.entity.TrainingLocation;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    /**
     * Метод поиска и получения списка упражнений указанной локации
     * @param trainingLocation экземпляр класса TrainingLocation, содержит информацию о требуемой локации упражнений
     * @return список экземпляров класса ExerciseWrapper
     * @throws ServerException генерирует исключение с кодом EXERCISE_LIST_ERROR
     */
    public List<ExerciseWrapper> getAllExercisesByTrainingLocation(TrainingLocation trainingLocation) throws ServerException{
        try{
            return exerciseRepository.findAllByTrainingLocation(trainingLocation).stream().map(ExerciseWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.EXERCISE_LIST_ERROR), ex);
        }
    }

    /**
     * Метод получения списка упражнений с указанным именем
     * @param name наименование запрашиваемого упражнения
     * @return список экземпляров класса ExerciseWrapper с информацией о найденных упражнениях
     * @throws ServerException генерирует исключение с кодом EXERCISE_LIST_ERROR
     */
    public List<ExerciseWrapper> getAllByName(String name) throws ServerException{
        try {
            return exerciseRepository.findAllByNameLikeIgnoreCase(name).stream().map(ExerciseWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.EXERCISE_LIST_ERROR), ex);
        }
    }

    /**
     * Метод получения единичного экземпляра класса ExerciseWrapper по переданному идентификатору
     * @param id идентификатор запрашиваемого упражнения
     * @return экземпляр класса ExerciseWrapper с данными из результата запроса
     * @throws ServerException генерирует иключение с кодом EXERCISE_INFO_ERROR
     */
    public ExerciseWrapper getById(Short id) throws ServerException{
        try {
            return new ExerciseWrapper(getExercise(id));
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.EXERCISE_INFO_ERROR), ex);
        }
    }

    /**
     * Метод получения единичного экземпляра класса Exercise по переданному идентификатору
     * @param id идентификатор запрашиваемого упражнения
     * @return экземпляр класса Exercise с данными из результата запроса
     * @throws ServerException генерирует исключение с кодом ошибки DATA_NOT_FOUND
     */
    private Exercise getExercise(Short id) throws ServerException{
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

}
