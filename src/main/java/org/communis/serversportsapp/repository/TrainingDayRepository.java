package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.TrainingDay;
import org.communis.serversportsapp.entity.TrainingProgram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingDayRepository extends JpaRepository<TrainingDay, Long> {

    /**
     * Метод поиска списка тренировочных дней переданной тренировочной программы
     * @param trainingProgram экземпляр класса тренировочной программы
     * @return список экземпляров класса TrainingDay
     */
    List<TrainingDay> findByTrainingProgram(TrainingProgram trainingProgram);
}
