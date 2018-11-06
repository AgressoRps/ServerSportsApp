package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Short> {

    /**
     * Метод поиска и получения первого вхождения в таблицу указанного имени
     * @param name наименование достижения
     * @return экземпляр класса Progress
     */
    Optional<Progress> findFirstByName(String name);
}
