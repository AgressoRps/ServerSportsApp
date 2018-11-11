package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.TrainingLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainingLocationRepository extends JpaRepository<TrainingLocation, Short> {

    /**
     * Метод поиска и получения первого вхождения в таблицу указанного имени
     * @param name наименование тренировочной локации
     * @return экземпляр класса TrainingLocation
     */
    Optional<TrainingLocation> findFirstByName(String name);

    /**
     * Метод поиска и получения списка всех существующих тренировочных локаций
     * @return список экземпляров класса TrainingLocation (список тренировочных локаций)
     */
    List<TrainingLocation> findAll();

    /**
     * Метод поиска и получения тренировочной локации по идентификатору
     * @param id идентификатор тренировочной локации
     * @return экземпляр класса TrainingLocation (тренировочная локация)
     */
    Optional<TrainingLocation> findById(Short id);
}
