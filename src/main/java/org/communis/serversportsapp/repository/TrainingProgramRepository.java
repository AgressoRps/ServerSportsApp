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
     * @return экземпляр класса TrainingProgram
     */
    Optional<TrainingProgram> findById(Long id);

    /**
     * Метод поиска тренировочных программ по состоянию
     * @param trainingProgramState состояние программы, по которому происходит отбор экземпляров
     * @return список экземпляров класса TrainingProgram
     */
    List<TrainingProgram> findByProgramState(TrainingProgramState trainingProgramState);
}
