package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.RankUser;
import org.communis.serversportsapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RankUserRepository extends JpaRepository<RankUser, Long> {

    /**
     * Метод поиска и получения всех данных связанных с переданным идентификатором пользователя
     * @param userID идентификатор пользователя приложения
     * @return список экземпляров класса RankUser (список званий пользователя)
     */
    List<RankUser> findAllByUserID(Long userID);

    /**
     * Метод поиска и получения записи по переданному идентификатору
     * @param rankUserID идентификатор записи (звания пользователя)
     * @return экземпляр класса RankUser (звание пользователя)
     */
    Optional<RankUser> findById(Long rankUserID);
}
