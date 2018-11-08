package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.TrainingDay;
import org.communis.serversportsapp.entity.TrainingDayContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainingDayContentRepository extends JpaRepository<TrainingDayContent, Long> {

    /**
     * Метод поиска и получения всего содержания указанного тренировочного дня
     * @param trainingDay тренировочный день, экземпляр класса TrainingDay
     * @return список экземпляров класса TrainingDayContent
     */
    @Query(value = "FROM TrainingDayContent content WHERE content.trainingDay =:day")
    List<TrainingDayContent> findAllByTrainingDay(@Param("day") TrainingDay trainingDay);
}
