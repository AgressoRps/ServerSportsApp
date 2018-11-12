package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.UserAppWrapper;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/user")
public class UserAppController {
    private final UserAppService userAppService;

    @Autowired
    public UserAppController(UserAppService userAppService){
        this.userAppService = userAppService;
    }

    /**
     * Метод реагирует на запрос /user/{id}, выполняет запрос к бд
     * для получения данных указанного пользователя по идентификатору
     * @param id идентификатор запрашиваемого пользователя
     * @return UserAppWrapper - содержит допустимые для отправки данные о пользователе
     * @throws ServerException в случае ошибки во время выполнения - генерация исключения
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserAppWrapper getUserById(@PathVariable("id") Long id) throws ServerException{
        return userAppService.getById(id);
    }

    /**
     * Метод реагирует на запрос /user/login/{login}, выполняет запрос к бд
     * для получения данных указанного пользователя по логину
     * @param login логин пользователя
     * @return экземпляр класса UserAppWrapper (пользователь)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public UserAppWrapper getUserByLogin(@PathVariable("login") String login) throws ServerException{
        return userAppService.getByLogin(login);
    }

    /**
     * Метод реагирует на запрос /user/email/{email}, выполняет запрос к бд
     * для получения данных указанного пользователя по электронной почте
     * @param email электронная почта пользователя
     * @return экземпляр класса UserAppWrapper (пользователь)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public UserAppWrapper getUserByEmail(@PathVariable("email") String email) throws ServerException{
        return userAppService.getByEmail(email);
    }

    /**
     * Метод реагирует на запрос /user/login-email/{value}, выполняет запрос к бд
     * для поиска пользователя по логину либо электронной почте
     * @param value логин либо электронная почта
     * @return экземпляр класса UserAppWrapper (пользователь)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/login-email/{value}", method = RequestMethod.GET)
    public UserAppWrapper getUserByLoginOrEmail(@PathVariable("value") String value) throws ServerException{
        return userAppService.getByLoginOrEmail(value, value);
    }

    /**
     * Метод реагирует на запрос /user/all/name-login/{email}, выполняет запрос к бд
     * для поиска списка пользователей соответствующих переданному имени или логину
     * @param value имя либо логин пользователя
     * @return список экземпляров класса UserAppWrapper (список найденных пользователей)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/all/name-login/{value}", method = RequestMethod.GET)
    public List<UserAppWrapper> getAllUsersByNameOrLogin(@PathVariable("value") String value) throws ServerException{
        return userAppService.getByNameLikeOrLoginLike(value, value);
    }

    /**
     * Метод реагирует на запрос /user/role/{role}, выполняет запрос к бд
     * для поиска списка пользователей соответствующих переданной роли
     * @param role роль пользователя
     * @return список экземпляров класса UserAppWrapper (список найденных пользователей)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/role/{role}", method = RequestMethod.GET)
    public List<UserAppWrapper> getAllUsersByRole(@PathVariable("role") String role) throws ServerException{
        return userAppService.getByRole(role);
    }
}
