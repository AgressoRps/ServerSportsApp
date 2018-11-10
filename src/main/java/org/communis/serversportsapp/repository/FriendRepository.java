package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Friend;
import org.communis.serversportsapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {

    /**
     * Метод поиска и получения всех данных таблицы связанных с запрашиваемым
     * @param user идентификатор пользователя приложения
     * @return список экземпляров класса Friend
     */
    @Query(value = "FROM Friend fr WHERE fr.userID =:user")
    List<Friend> findAllByUserID(@Param("user") Long user);

}
