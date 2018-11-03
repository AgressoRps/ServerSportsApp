package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.enums.UserAppRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {
    /**
     * Метод поиска пользователя по логину
     * @param login логин пользователя, которого нужно найти
     * @return если такой пользователь существует, то он возвращется
     */
    Optional<UserApp> findFirstByLogin(String login);

    /**
     * Метод поиска пользователей по роли
     * @param role роль пользователей, которых нужно найти
     * @return если такие пользователи существуют, то они возвращется
     */
    Optional<UserApp> findByRole(UserAppRole role);

    /**
     * Метод поиска пользователя по идентификатор
     * @param id идентификатор пользователя, которого нужно найти
     * @return если такой пользователь существует, то он возвращается
     */
    Optional<UserApp> findById(Long id);
}
