package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.RankUserWrapper;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.RankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/rank-user")
public class RankUserController {

    private final RankUserService rankUserService;

    @Autowired
    public RankUserController(RankUserService rankUserService){
        this.rankUserService = rankUserService;
    }

    /**
     * Метод реагирует на запрос /rank-user/{id}, выполняет запрос к бд для получения
     * всех званий пользователя
     * @param id идентификатор пользователя
     * @return список экземпляров класса RankUserWrapper (список всех званий указанного пользователя)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<RankUserWrapper> getAllRanksUser(@PathVariable("id") Long id) throws ServerException{
        return rankUserService.getAllRanksUser(id);
    }

}
