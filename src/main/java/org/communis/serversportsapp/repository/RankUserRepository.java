package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.RankUser;
import org.communis.serversportsapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RankUserRepository extends JpaRepository<RankUser, Long> {

    /**
     * Метод поиска и получения всех данных связанных с переданным пользователем
     * @param user пользователь приложения, экземпляр класса UserApp
     * @return список экземпляров класса RankUser
     */
    @Query(value = "FROM RankUser rankUser WHERE rankUser.user =:user")
    List<RankUser> findAllByUser(@Param("user") UserApp user);
}
