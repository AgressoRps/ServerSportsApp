package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.TrainingProgramWrapper;
import org.communis.serversportsapp.entity.TrainingProgram;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformation;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.TrainingProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class TrainingProgramService {

    private final TrainingProgramRepository trainingProgramRepository;

    @Autowired
    public TrainingProgramService(TrainingProgramRepository trainingProgramRepository){
        this.trainingProgramRepository = trainingProgramRepository;
    }

    /**
     * Метод поиска и получения всех тренировочных программ
     * @return список экземпляров класса TrainingProgramWrapper (список тренировочных программ)
     * @throws ServerException генерирует исключение с кодом TRAINING_PROGRAM_LIST_ERROR
     */
    public List<TrainingProgramWrapper> getAllTrainingPrograms() throws ServerException{
        try {
            return trainingProgramRepository.findAll().stream().map(TrainingProgramWrapper::new).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_PROGRAM_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения тренировочных по идентификатору пользователя и тренировочной локации
     * @param userID идентификатор пользователя
     * @param trainingLocationID идентификатор тренировочной локации
     * @return список экземпляров класса TrainingProgramWrapper (список тренировочных программ)
     * @throws ServerException генерирует исключение с кодом TRAINING_PROGRAM_LIST_ERROR
     */
    public List<TrainingProgramWrapper> getByUserIdAndTrainingLocationId(Long userID, Short trainingLocationID) throws ServerException{
        try{
            return trainingProgramRepository.findAllByUserIDAndTrainingLocationID(userID, trainingLocationID).stream().map(TrainingProgramWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_PROGRAM_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения всех тренировочных программ по идентификатору пользователя
     * @param id идентификатор пользователя
     * @return список экземпляров класса TrainingProgramWrapper (список тренировочных программ)
     * @throws ServerException генерирует исключение с кодом TRAINING_PROGRAM_LIST_ERROR
     */
    public List<TrainingProgramWrapper> getByUserId(Long id) throws ServerException{
        try {
            return trainingProgramRepository.findAllByUserID(id).stream().map(TrainingProgramWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_PROGRAM_LIST_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения тренировочной программы по переданному идентификатору
     * @param id идентификатор тренировочной программы
     * @return экземпляр класса TrainingProgramWrapper (тренировочная программа)
     * @throws ServerException генерирует исключение с кодом TRAINING_PROGRAM_INFO_ERROR
     */
    public TrainingProgramWrapper getById(Long id) throws ServerException{
        try {
            return new TrainingProgramWrapper(getTrainingProgram(id));
        }catch (ServerException ex) {
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_PROGRAM_INFO_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения тренировочной программы по переданному идентификатору
     * @param id идентификатор требуемой тренировочной программы
     * @return экземпляр класса TrainingProgram (тренировочная программа)
     * @throws ServerException генерирует исключение DATA_NOT_FOUND
     */
    private TrainingProgram getTrainingProgram(Long id) throws ServerException{
        return trainingProgramRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

    /**
     * Метод добавления новой тренировочной программы в базу данных
     * @param trainingProgramWrapper содержит данные тренировочной программы
     * @return true - при успешном добавлении
     * @throws ServerException генерирует исключение с кодом DATA_VALIDATE_ERROR либо TRAINING_PROGRAM_ADD_ERROR
     */
    public String addTrainingProgram(TrainingProgramWrapper trainingProgramWrapper) throws ServerException{
        try{
            if (trainingProgramWrapper.getUserID() != null && trainingProgramWrapper.getTrainingLocationID() != null
            && trainingProgramWrapper.getLevelDifficultyWrapper().getId() != null){
                TrainingProgram trainingProgram = new TrainingProgram();
                trainingProgramWrapper.fromWrapper(trainingProgram);
                trainingProgramRepository.save(trainingProgram);
                return "true";
            }else {
                throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
            }
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_PROGRAM_ADD_ERROR), ex);
        }
    }

    /**
     * Метод обновления данных существующей тренировочной программы
     * @param trainingProgramWrapper содержит обновленные данные
     * @return true - при успешном обновлении данных
     * @throws ServerException генерирует исключение с кодом TRAINING_PROGRAM_UPDATE_ERROR
     */
    public String editTrainingProgram(TrainingProgramWrapper trainingProgramWrapper) throws ServerException{
        try{
            TrainingProgram trainingProgram = getTrainingProgram(trainingProgramWrapper.getId());
            trainingProgramWrapper.fromWrapper(trainingProgram);
            trainingProgramRepository.save(trainingProgram);
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_PROGRAM_UPDATE_ERROR), ex);
        }
    }

    /**
     * Метод удаления существующей тренировочной программы из базы данных
     * @param trainingProgramWrapper содержит идентификатор удаляемой записи
     * @return true - при успешном удалении
     * @throws ServerException генерирует исключение с кодом TRAINING_PROGRAM_DELETE_ERROR
     */
    public String deleteTrainingProgram(TrainingProgramWrapper trainingProgramWrapper) throws ServerException{
        try{
            trainingProgramRepository.delete(trainingProgramWrapper.getId());
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_PROGRAM_DELETE_ERROR), ex);
        }
    }
}
