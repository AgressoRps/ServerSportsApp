package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.ProgressUser;
import org.communis.serversportsapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProgressUserRepository extends JpaRepository<ProgressUser, Long> {

    /**
     * Метод поиска и получения всех данных связанных с переданным пользователем
     * @param userID идентификатор пользователя
     * @return список экземпляров класса ProgressUser (список достижений пользователя)
     */
    List<ProgressUser> findAllByUserID(Long userID);

    /**
     * Метод поиска и получения достижения пользователя по указанному идентификатору
     * @param progressUserId идентификатор записи, которую необходимо получить
     * @return экземпляр класса ProgressUser (содержит достижение)
     */
    Optional<ProgressUser> findById(Long progressUserId);
}
