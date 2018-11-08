package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Statistics;
import org.communis.serversportsapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

    /**
     * Метод поиска и получения всей статистики связанной с указанным пользователем
     * @param userApp пользователь приложения, экземпляр класса UserApp
     * @return список экземпляров класса Statistics
     */
    @Query(value = "FROM Statistics statistics WHERE statistics.user =:user")
    List<Statistics> findAllByUser(@Param("user") UserApp userApp);
}
