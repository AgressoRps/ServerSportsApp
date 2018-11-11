package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.TrainingDay;
import org.communis.serversportsapp.entity.TrainingProgram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainingDayRepository extends JpaRepository<TrainingDay, Long> {

    /**
     * Метод поиска списка тренировочных дней по идентификатору тренировочной программы
     * @param id идентификатор тренировочной программы
     * @return список экземпляров класса TrainingDay (список тренировочных дней)
     */
    List<TrainingDay> findAllByTrainingProgramID(Long id);

    /**
     * Метод поиска всех тренировочных дней
     * @return список экземпляров класса TrainingDay (список всех тренировочных дней)
     */
    List<TrainingDay> findAll();

    /**
     * Метод поиска тренировочного дня по переданному идентификатору
     * @param id идентификатор тренировочного дня
     * @return экземпляр класса TrainingDay (тренировочный день)
     */
    Optional<TrainingDay> findById(Long id);
}
