package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.TrainingDay;
import org.communis.serversportsapp.entity.TrainingDayContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TrainingDayContentRepository extends JpaRepository<TrainingDayContent, Long> {

    /**
     * Метод поиска и получения всего контента указанного тренировочного дня по переданному идентификатору таблицы TrainingDay
     * @param trainingDayId идентификатор тренировочного дня
     * @return список экземпляров класса TrainingDayContent
     */
    List<TrainingDayContent> findAllByTrainingDayID(Long trainingDayId);

    /**
     * Метод поиска и получения контента тренировочного дня по переданному идентификатору
     * @param id идентификатор контента тренировочного дня
     * @return экземпляр класса TrainingDayContent с данными соответствующими переданному идентификатору
     */
    Optional<TrainingDayContent> findById(Long id);

    /**
     * Метод поиска и получения всех значений таблицы
     * @return список экземпляров класса TrainingDayContent (список контента тренировочных дней)
     */
    List<TrainingDayContent> findAll();
}
