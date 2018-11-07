package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.ProgressUser;
import org.communis.serversportsapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressUserRepository extends JpaRepository<ProgressUser, Long> {

    /**
     * Метод поиска и получения всех данных связанных с переданным пользователем
     * @param user пользователь приложения, экземпляр класса UserApp
     * @return список экземпляров класса ProgressUser
     */
    List<ProgressUser> findAllByUser(UserApp user);
}
