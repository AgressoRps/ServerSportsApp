package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RankRepository extends JpaRepository<Rank, Short> {

    /**
     * Метод поиска и получения первого вхождения в таблицу указанного имени
     * @param name наименование звания
     * @return экземпляр класса Rank
     */
    Optional<Rank> findFirstByName(String name);

    /**
     * Метод поиска и получения данных связанных с указанным идентификатором
     * @param id идентификатор звания
     * @return экземпляр класса Rank (звание)
     */
    Optional<Rank> findById(Short id);

    /**
     * Метод получения всех званий
     * @return список экземпляров класса Rank (список званий)
     */
    List<Rank> findAll();
}
