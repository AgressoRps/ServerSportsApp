package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DayRepository extends JpaRepository<Day, Short> {

    /**
     * Метод поиска и получения первого вхождения в таблицу даннных по с указанным именем
     * @param name наименование дня
     * @return экземпляр класса Day
     */
    Optional<Day> findFirstByName(String name);

    /**
     * Метод поиска и получения дня по идентификатору
     * @param id индентификатор дня
     * @return экземпляр класса Day
     */
    Optional<Day> findById(Short id);
}
