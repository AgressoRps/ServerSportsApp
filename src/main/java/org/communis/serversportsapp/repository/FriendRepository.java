package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.Friend;
import org.communis.serversportsapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend, Long> {

    /**
     * Метод поиска и получения всех данных таблицы связанных с запрашиваемым пользователем
     * @param userID идентификатор пользователя приложения
     * @return список экземпляров класса Friend (список друзей)
     */
    List<Friend> findAllByUserID(Long userID);

    /**
     * Метод поиска и получения данных по переданному идентификатору
     * @param id идентификатор запрашиваемой записи
     * @return экземпляр класса Friend (данные о друге)
     */
    Optional<Friend> findById(Long id);

    /**
     * Метод поиска совпадений, проверяет, существует ли друг
     * @param userApp друг, которого нужно найти
     * @param userID пользователь, друга которого ищем
     * @return экземпляр класса Friend
     */
    Optional<Friend> findFriendByUserIDAndFriend(Long userID, UserApp userApp);

}
