package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.LevelDifficulty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelDifficultyRepository extends JpaRepository<LevelDifficulty, Short> {

    /**
     * Метод поиска и получения первого вхождения в таблицу указанного имени
     * @param name наименование достижения
     * @return экземпляр класса Progress
     */
    Optional<LevelDifficulty> findFirstByName(String name);
}
