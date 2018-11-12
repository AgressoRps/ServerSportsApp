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
     * @param id идентификатор тренировочной локации
     * @return список экземпляров класса ExerciseWrapper
     * @throws ServerException генерирует исключение с кодом EXERCISE_LIST_ERROR
     */
    public List<ExerciseWrapper> getAllExercisesByTrainingLocationId(Short id) throws ServerException{
        try{
            return exerciseRepository.findAllByTrainingLocationID(id).stream().map(ExerciseWrapper::new).collect(Collectors.toList());
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

    /**
     * Метод добавления нового упражнения в базу данных
     * @param exerciseWrapper полученные данные от пользователя (упражнение)
     * @return при успешном выполнении - true
     * @throws ServerException генерирует исключение с кодом DATA_VALIDATE_ERROR и EXERCISE_ADD_ERROR
     */
    public String addExercise(ExerciseWrapper exerciseWrapper) throws ServerException{
        try {
            if (exerciseWrapper.getName() != null && !exerciseWrapper.getName().equals("")){
                Exercise exercise = new Exercise();
                exerciseWrapper.fromWrapper(exercise);
                exerciseRepository.save(exercise);
                return "true";
            }else {
                throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
            }
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.EXERCISE_ADD_ERROR), ex);
        }
    }

    /**
     * Метод редактирования упражнения
     * @param exerciseWrapper измененнное упражнение
     * @return при успешном выполнении - true
     * @throws ServerException в случае ошибки генерирует исключение с кодом EXERCISE_UPDATE_ERROR
     */
    public String editExercise(ExerciseWrapper exerciseWrapper) throws ServerException{
        try {
            Exercise exercise = getExercise(exerciseWrapper.getId());
            exerciseWrapper.fromWrapper(exercise);
            exerciseRepository.save(exercise);
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.EXERCISE_UPDATE_ERROR), ex);
        }
    }

    /**
     * Метод удаления упражнения по переданному идентификатору
     * @param id идентификатор упражнения, которое требуется удалить
     * @return при успешном выполнении - true
     * @throws ServerException в случае ошибки генерирует исключение с кодом EXERCISE_DELETE_ERROR
     */
    public String deleteExercise(Short id) throws ServerException{
        try {
            Exercise exercise = getExercise(id);
            exerciseRepository.delete(exercise);
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.EXERCISE_DELETE_ERROR), ex);
        }
    }

}
