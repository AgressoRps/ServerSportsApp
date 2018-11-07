package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.TrainingLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainingLocationRepository extends JpaRepository<TrainingLocation, Short> {

    /**
     * Метод поиска и получения первого вхождения в таблицу указанного имени
     * @param name наименование тренировочной локации
     * @return экземпляр класса TrainingLocation
     */
    Optional<TrainingLocation> findFirstByName(String name);
}
