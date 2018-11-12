package org.communis.serversportsapp.repository;

import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.enums.UserAppRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {

    /**
     * Метод поиска пользователя по логину
     * @param login логин пользователя, которого нужно найти
     * @return экземпляр класса UserApp
     */
    Optional<UserApp> findByLogin(String login);

    /**
     * Метод поиска пользователя по электронной почте
     * @param email почта пользователя, которого нужно найти
     * @return экземпляр класса UserApp
     */
    Optional<UserApp> findByEmail(String email);

    /**
     * Метод поиска пользователя по имени либо логину
     * @param name имя пользователя
     * @param login логин пользователя
     * @return список экземпляров класса UserApp (список пользователей)
     */
    List<UserApp> findAllByNameLikeOrLoginLike(String name, String login);

    /**
     * Метод поиска пользователей по роли
     * @param role роль пользователей, которых нужно найти
     * @return список пользователей, экземпляры класса UserApp
     */
    List<UserApp> findByRole(UserAppRole role);

    /**
     * Метод поиска пользователя по идентификатор
     * @param id идентификатор пользователя, которого нужно найти
     * @return экземпляр класса UserApp
     */
    Optional<UserApp> findById(Long id);
}
