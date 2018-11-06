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
     * Метод получения данных указанного пользователя по идентификатору
     * @param id идентификатор запрашиваемого пользователя
     * @return UserAppWrapper - содержит допустимые для отправки данные о пользователе
     * @throws ServerException в случае ошибки во время выполнения - генерация исключения
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserAppWrapper getUserById(@PathVariable("id") Long id) throws ServerException{
        return userAppService.getById(id);
    }
}
