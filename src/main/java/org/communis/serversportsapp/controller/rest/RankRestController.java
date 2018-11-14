package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.RankWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rank")
public class RankRestController {

    private final RankService rankService;

    @Autowired
    public RankRestController(RankService rankService){
        this.rankService = rankService;
    }

    /**
     * Метод реагирует на запрос /rank/add, выполняет запрос к бд
     * для добавления нового звания
     * @param rankWrapper данные, которые необходимо добавить
     * @return true - при успешном добавлении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addRank(RankWrapper rankWrapper) throws ServerException{
        return rankService.addRank(rankWrapper);
    }

    /**
     * Метод реагирует на запрос /rank/edit, выполняет запрос к бд
     * для обновления информации новыми данными
     * @param rankWrapper данные, которыми необходимо обновить запись
     * @return true - при успешном обновлении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    @ResponseBody
    public String editRank(RankWrapper rankWrapper) throws ServerException{
        return rankService.editRank(rankWrapper);
    }

    /**
     * Метод реагирует на запрос /rank/delete, выполняет запрос к бд
     * для удаления записи соответствующей переданным данным
     * @param rankWrapper содержит идентификатор записи, по которому выполняется удаление
     * @return true - при успешном удалении из бд
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteRank(RankWrapper rankWrapper) throws ServerException{
        return rankService.deleteRank(rankWrapper);
    }
}
