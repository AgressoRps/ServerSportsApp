package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.ProgressUserWrapper;
import org.communis.serversportsapp.dto.UserAppWrapper;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.ProgressUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/progress/user")
public class ProgressUserController {

    private final ProgressUserService progressUserService;

    @Autowired
    public ProgressUserController(ProgressUserService progressUserService){
        this.progressUserService = progressUserService;
    }

    /**
     * Метод реагирует на запрос /progress/user/{id}, выполняет запрос к бд
     * для получения списка всех достижений пользователя
     * @param id идентификатор пользователя, достижения которого необходимо получить
     * @return список экземпляров класса ProgressUserWrapper (список достижений пользователя)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<ProgressUserWrapper> getAllProgressUser(@PathVariable("id") Long id) throws ServerException {
        return progressUserService.getAllProgressUser(id);
    }

}
