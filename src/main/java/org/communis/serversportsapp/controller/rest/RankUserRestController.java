package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.RankUserWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.RankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rank-user")
public class RankUserRestController {

    private final RankUserService rankUserService;

    @Autowired
    public RankUserRestController(RankUserService rankUserService){
        this.rankUserService = rankUserService;
    }

    /**
     * Метод реагирует на запрос /rank-user/add, выполняет запрос к бд
     * для добавления нового звания пользователю
     * @param rankUserWrapper содержит данные, необходимые для добавления
     * @return true - при успешном добавлении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addRankUser(RankUserWrapper rankUserWrapper) throws ServerException{
        return rankUserService.addRankUser(rankUserWrapper);
    }

    /**
     * Метод реагирует на запрос /rank-user/delete, выполняет запрос к бд
     * для удаления звания пользователя
     * @param rankUserWrapper содержит идентификатор записи, которую необходимо удалить
     * @return true - при успешном удалении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteRankUser(RankUserWrapper rankUserWrapper) throws ServerException{
        return rankUserService.deleteRankUser(rankUserWrapper);
    }
}
