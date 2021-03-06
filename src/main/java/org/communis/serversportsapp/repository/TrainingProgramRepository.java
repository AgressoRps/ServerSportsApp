package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.TrainingProgram;
import org.communis.serversportsapp.enums.TrainingProgramState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, Long> {

    /**
     * Метод поиска тренировочной программы по идентификатору
     * @param id идентификатор тренировочной программы, которую нужно найти
     * @return экземпляр класса TrainingProgram (тренировочная программа)
     */
    Optional<TrainingProgram> findById(Long id);

    /**
     * Метод поиска всех тренировочных программ указанного пользователя
     * @param id идентификатор пользователя
     * @return список экземпляров класса TrainingProgram (список тренировочных программ пользователя)
     */
    List<TrainingProgram> findAllByUserID(Long id);

    /**
     * Метод поиска всех тренировочных программ указанного пользователя на указанных локациях
     * @param userID идентификатор пользователя
     * @param trainingLocationID идентификатор тренировочной локации
     * @return список экземпляров класса TrainingProgram (тренировочные программы)
     */
    List<TrainingProgram> findAllByUserIDAndTrainingLocationID(Long userID, Short trainingLocationID);

    /**
     * Метод поика и получения всех существующих тренировочных программ
     * @return список экземпляров класса TrainingProgram (список тренировочных программ)
     */
    List<TrainingProgram> findAll();

    /**
     * Метод поиска тренировочных программ по состоянию
     * @param trainingProgramState состояние программы, по которому происходит отбор экземпляров
     * @return список экземпляров класса TrainingProgram
     */
    List<TrainingProgram> findByTrainingProgramState(TrainingProgramState trainingProgramState);
}
