package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Statistics;
import org.communis.serversportsapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

    /**
     * Метод поиска и получения всей статистики связанной с указанным пользователем
     * @param id идентификатор пользователя, статистику которого необходимо получить
     * @return список экземпляров класса Statistics (список статистки пользователя)
     */
    List<Statistics> findAllByUserID(Long id);

    /**
     * Метод поиска и получения статистики по идентификатору пользователя и идентификатору локации
     * @param userID идентификатор пользователя, статистику которого необходимо получить
     * @param locationID идентификатор локации, статистику по которой необходимо получить
     * @return список экземпляров класса Statistics (статистика пользователя)
     */
    List<Statistics> findAllByUserIDAndTrainingLocationID(Long userID, Short locationID);

    /**
     * Метод поиска и получения статистики по идентификатору пользователя указанной тренировочной программы
     * @param userID идентификатор пользователя
     * @param programID идентификатор тренировочной программы
     * @return список экземпляров класса Statistics (список статистик)
     */
    List<Statistics> findAllByUserIDAndTrainingProgramID(Long userID, Long programID);

    /**
     * Метод поиска и получения статистики по идентификатору пользователя и тренировочного дня
     * @param userID идентификатор пользователя
     * @param trainingDayID идентификатор интересующего тренировочного дня
     * @return экземпляр класса Statistics (статистика указанного дня)
     */
    Optional<Statistics> findFirstByUserIDAndTrainingDayID(Long userID, Long trainingDayID);

    /**
     * Метод поиска и получения статистики по идентификатору
     * @param id идентификатор статистики
     * @return экземпляр класса Statistics (статистка)
     */
    Optional<Statistics> findById(Long id);
}
