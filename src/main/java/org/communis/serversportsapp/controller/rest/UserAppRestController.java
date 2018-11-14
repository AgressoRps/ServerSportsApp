package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.UserAppWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserAppRestController {

    private final UserAppService userAppService;

    @Autowired
    public UserAppRestController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    /**
     * Метод реагирует на запрос /user/add, добавляет нового пользователя
     * @param userAppWrapper содержит данные пользователя
     * @return true - при успешном выполнении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(UserAppWrapper userAppWrapper) throws ServerException {
        return userAppService.addUser(userAppWrapper);
    }

    /**
     * Метод реагирует на запрос /user/edit, редактирует пользователя
     * @param userAppWrapper содержит обновленные данные
     * @return true - при успешном обновлении пользователя
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    @ResponseBody
    public String editUser(UserAppWrapper userAppWrapper) throws ServerException {
        return userAppService.editUser(userAppWrapper);
    }

    /**
     * Метод реагирует на запрос /user/delete, удаляет пользователя из бд
     * @param userAppWrapper содержит идентификатор удаляемого пользователя
     * @return true - при успешном удалении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(UserAppWrapper userAppWrapper) throws ServerException {
        return userAppService.deleteUser(userAppWrapper);
    }

    /**
     * Метод реагирует на запрос /user/online, меняет состояние пользователя
     * @param userAppWrapper содержит идентификатор пользователя
     * @return true - при успешном изменении состояния
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/online", method = RequestMethod.PATCH)
    @ResponseBody
    public String setOnlineUser(UserAppWrapper userAppWrapper) throws ServerException {
        return userAppService.setUserStateOnline(userAppWrapper);
    }

    /**
     * Метод реагирует на запрос /user/offline, меняет состояние пользователя
     * @param userAppWrapper содержит идентификатор пользователя
     * @return true - при успешном изменении состояния
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/offline", method = RequestMethod.PATCH)
    @ResponseBody
    public String setOfflineUser(UserAppWrapper userAppWrapper) throws ServerException {
        return userAppService.setUserStateOffline(userAppWrapper);
    }

    /**
     * Метод реагирует на запрос /user/removed, меняет состояние пользователя
     * @param userAppWrapper содержит идентификатор пользователя
     * @return true - при успешном изменении состояния
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/removed", method = RequestMethod.PATCH)
    @ResponseBody
    public String setRemovedUser(UserAppWrapper userAppWrapper) throws ServerException {
        return userAppService.setUserStateRemoved(userAppWrapper);
    }

    /**
     * Метод реагирует на запрос /user/blocked, меняет состояние пользователя
     * @param userAppWrapper содержит идентификатор пользователя
     * @return true - при успешном изменении состояния
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/blocked", method = RequestMethod.PATCH)
    @ResponseBody
    public String setBlockedUser(UserAppWrapper userAppWrapper) throws ServerException {
        return userAppService.setUserStateBlocked(userAppWrapper);
    }
}

