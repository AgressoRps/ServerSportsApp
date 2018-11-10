package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.LevelDifficulty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LevelDifficultyRepository extends JpaRepository<LevelDifficulty, Short> {

    /**
     * Метод поиска и получения первого вхождения в таблицу указанного имени
     * @param name наименование уровня сложности
     * @return экземпляр класса LevelDifficulty
     */
    Optional<LevelDifficulty> findFirstByName(String name);

    /**
     * Метод поиска и получения данных уровня сложности по идентификатору
     * @param id идентификатор уровня сложности
     * @return экземпляр класса LevelDifficulty, содержащий данные найденного уровня сложности
     */
    Optional<LevelDifficulty> findById(Short id);

    /**
     * Метод поиска и получения списка всех уровней сложности
     * @return список экземпляров класса LevelDifficulty (уровней сложности)
     */
    List<LevelDifficulty> findAll();
}
