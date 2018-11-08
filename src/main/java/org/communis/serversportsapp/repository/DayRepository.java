package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DayRepository extends JpaRepository<Day, Short> {

    /**
     * Метод поиска и получения первого вхождения в таблицу указанного имени
     * @param name наименование звания
     * @return экземпляр класса Day
     */
    Optional<Day> findFirstByName(String name);
}
