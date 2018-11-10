package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Exercise;
import org.communis.serversportsapp.entity.TrainingLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Short> {

    /**
     * Метод поиска и получения всех упражнений связанных с переданной локацией
     * @param trainingLocation локация проведения тренировки, экземпляр класса TrainingLocation
     * @return список экземпляров класса Exercise
     */
    @Query(value = "FROM Exercise exercise WHERE exercise.trainingLocation =:location")
    List<Exercise> findAllByTrainingLocation(@Param("location")TrainingLocation trainingLocation);

    /**
     * Метод поиска и получения одного упражнения с указанным идентификатором
     * @param id идентификатор требуемого упражнения
     * @return экземпляр класса Exercise
     */
    Optional<Exercise> findById(Short id);

    /**
     * Метод поиска и получения списка упражнений по имени
     * @param name наименование упражнения
     * @return список экземпляров класса Exercise
     */
    List<Exercise> findAllByNameLikeIgnoreCase(String name);

}
