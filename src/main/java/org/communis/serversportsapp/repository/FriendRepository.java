package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Friend;
import org.communis.serversportsapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {

    /**
     * Метод поиска и получения всех данных таблицы связанных с запрашиваемым пользователем
     * @param userID идентификатор пользователя приложения
     * @return список экземпляров класса Friend (список друзей)
     */
    List<Friend> findAllByUserID(Long userID);

}
