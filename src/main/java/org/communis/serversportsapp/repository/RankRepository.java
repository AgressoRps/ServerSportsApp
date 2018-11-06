package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RankRepository extends JpaRepository<Rank, Short> {

    /**
     * Метод поиска и получения первого вхождения в таблицу указанного имени
     * @param name наименование достижения
     * @return экземпляр класса Rank
     */
    Optional<Rank> findFirstByName(String name);
}
