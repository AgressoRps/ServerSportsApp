package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Short> {

    /**
     * Метод поиска и получения первого вхождения в таблицу указанного имени
     * @param name наименование достижения
     * @return экземпляр класса Progress
     */
    Optional<Progress> findFirstByName(String name);

    /**
     * Метод поиска и получения всех данных таблицы Progress
     * @return список экземпляров класса Progress (список достижений)
     */
    List<Progress> findAll();

    /**
     * Метод поиска и получения значения из бд по указанному идентификатору
     * @param id идентификатор достижения
     * @return экземпляр класса Progress с данными о достижении
     */
    Optional<Progress> findById(Short id);

}
