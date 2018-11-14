package org.communis.serversportsapp.service;

import org.communis.serversportsapp.dto.TrainingDayWrapper;
import org.communis.serversportsapp.dto.TrainingProgramWrapper;
import org.communis.serversportsapp.entity.TrainingDay;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.exception.error.ErrorCodeConstants;
import org.communis.serversportsapp.exception.error.ErrorInformationBuilder;
import org.communis.serversportsapp.repository.TrainingDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = ServerException.class)
public class TrainingDayService {

    private final TrainingDayRepository trainingDayRepository;

    @Autowired
    public TrainingDayService(TrainingDayRepository trainingDayRepository){
        this.trainingDayRepository = trainingDayRepository;
    }

    /**
     * Метод получения списка всех существующих тренировочных дней
     * @return список экземпляров класса TrainingDayWrapper (список всех тренировочных дней)
     * @throws ServerException генерирует исключение с кодом TRAINING_DAY_LIST_ERROR
     */
    public List<TrainingDayWrapper> getAllTrainingDays() throws ServerException{
        try {
            return trainingDayRepository.findAll().stream().map(TrainingDayWrapper::new).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_LIST_ERROR), ex);
        }
    }

    /**
     * Метод получения списка тренировочных дней связанных с указанной тренировочной программой
     * @param id идентификатор тренировочной программы
     * @return список экземпляров класса TrainingDayWrapper (список тренировочных дней)
     * @throws ServerException генерирует исключение с кодом TRAINING_DAY_LIST_ERROR
     */
    public List<TrainingDayWrapper> getAllByTrainingProgramId(Long id) throws ServerException{
        try{
            return trainingDayRepository.findAllByTrainingProgramID(id).stream().map(TrainingDayWrapper::new).collect(Collectors.toList());
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_LIST_ERROR), ex);
        }
    }

    /**
     * Метод получения тренировочного дня по переданному идентификатору
     * @param id идентификатор тренировочного дня
     * @return экземпляр класса TrainingDayWrapper (тренировочный день)
     * @throws ServerException
     */
    public TrainingDayWrapper getById(Long id) throws ServerException{
        try{
            return new TrainingDayWrapper(getTrainingDay(id));
        }catch (ServerException ex){
            throw ex;
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_INFO_ERROR), ex);
        }
    }

    /**
     * Метод поиска и получения тренировочного дня по переданному идентификатору
     * @param id идентификатор тренировочного дня
     * @return экземпляр класса TrainingDay (тренировочный день)
     * @throws ServerException генерирует исключение DATA_NOT_FOUND
     */
    private TrainingDay getTrainingDay(Long id) throws ServerException{
        return trainingDayRepository.findById(id)
                .orElseThrow(() -> new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_NOT_FOUND)));
    }

    /**
     * Метод добавления нового тренировочного дня в указанную тренировочную программу
     * @param trainingDayWrapper содержит всю добавляемую информацию
     * @return true - при успешном добавлении в бд
     * @throws ServerException генерирует исключение с кодом TRAINING_DAY_EXIST_ERROR либо DATA_VALIDATE_ERROR либо TRAINING_DAY_ADD_ERROR
     */
    public String addTrainingDay(TrainingDayWrapper trainingDayWrapper) throws ServerException{
        try{
            if (trainingDayWrapper.getTrainingProgramID() != null && trainingDayWrapper.getDayWrapper().getId() != null){
                TrainingDay trainingDay = new TrainingDay();
                trainingDayWrapper.fromWrapper(trainingDay);
                if (checkTrainingDay(getAllByTrainingProgramId(trainingDayWrapper.getTrainingProgramID()), trainingDayWrapper.getDayWrapper().getId())){
                    trainingDayRepository.save(trainingDay);
                    return "true";
                }else {
                    throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_EXIST_ERROR));
                }
            }else {
                throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
            }
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_ADD_ERROR), ex);
        }
    }

    /**
     * Метод редактирования тренировочного дня
     * @param trainingDayWrapper содержит обновленную информацию тренировочного дня
     * @return true - при успешном обновлении данных
     * @throws ServerException генерирует исключение с кодом TRAINING_DAY_UPDATE_ERROR
     */
    public String editTrainingDay(TrainingDayWrapper trainingDayWrapper) throws ServerException{
        try {
            TrainingDay trainingDay = getTrainingDay(trainingDayWrapper.getId());
            trainingDayWrapper.fromWrapper(trainingDay);
            trainingDayRepository.save(trainingDay);
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_UPDATE_ERROR), ex);
        }
    }

    /**
     * Метод удаления тренировочного дня из бд
     * @param trainingDayWrapper содержит идентификатор тренировочного дня, который необходимо удалить
     * @return true - при успешном удалении
     * @throws ServerException генерирует исключение с кодом TRAINING_DAY_DELETE_ERROR
     */
    public String deleteTrainingDay(TrainingDayWrapper trainingDayWrapper) throws ServerException{
        try {
            trainingDayRepository.delete(trainingDayWrapper.getId());
            return "true";
        }catch (Exception ex){
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.TRAINING_DAY_DELETE_ERROR), ex);
        }
    }

    /**
     * Метод поиска для проверки, существует ли в указанной тренировочной программы такой тренировочный день
     * @param trainingDayWrappers содержит список тренировочных дней указанной программы
     * @param dayID идентификатор дня, на который происходит проверка
     * @return true - в случае отсутствия указанного дня в списке тренировочных
     * false - если такой день уже существует 
     */
    private Boolean checkTrainingDay(List<TrainingDayWrapper> trainingDayWrappers, Short dayID){
        for(TrainingDayWrapper trainingDayWrapper : trainingDayWrappers){
            if (trainingDayWrapper.getDayWrapper().getId().equals(dayID)){
                return false;
            }
        }
        return true;
    }
}