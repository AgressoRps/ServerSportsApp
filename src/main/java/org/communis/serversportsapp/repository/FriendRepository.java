package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Friend;
import org.communis.serversportsapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {

    /**
     * Метод поиска и получения всех данных связанных с переданным пользователем
     * @param user пользователь приложения, экземпляр класса UserApp
     * @return список экземпляров класса Friend
     */
    @Query(value = "FROM Friend friend WHERE friend.user =:user")
    List<Friend> findAllByUser(@Param("user") UserApp user);

}
