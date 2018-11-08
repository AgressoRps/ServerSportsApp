package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.ProgressUser;
import org.communis.serversportsapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgressUserRepository extends JpaRepository<ProgressUser, Long> {

    /**
     * Метод поиска и получения всех данных связанных с переданным пользователем
     * @param id пользователь приложения, экземпляр класса UserApp
     * @return список экземпляров класса ProgressUser
     */
    //List<ProgressUser> findAllByUser(UserApp user);
    @Query(value = "FROM ProgressUser progress WHERE progress.user =:user")
    List<ProgressUser> findAllByUser(@Param("user") UserApp user);
}
