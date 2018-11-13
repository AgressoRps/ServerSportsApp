package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.ProgressUserWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.ProgressUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/progress-user")
public class ProgressUserRestController {

    private final ProgressUserService progressUserService;

    @Autowired
    public ProgressUserRestController(ProgressUserService progressUserService){
        this.progressUserService = progressUserService;
    }

    /**
     * Метод реагирует на запрос /progress-user/add, выполняет запрос к бд
     * для добавления нового достижения пользователя
     * @param progressUserWrapper содержит данные пользователя и достижения, которые необходимо добавить в бд
     * @return true - при успешном добавлении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addProgressUser(ProgressUserWrapper progressUserWrapper) throws ServerException{
        return progressUserService.addProgressUser(progressUserWrapper);
    }

    /**
     * Метод реагирует на запрос /progress-user/delete, выполняет запрос к бд
     * для удаления достижения пользователя по идентификатору записи
     * @param progressUserWrapper содержит идентификатор удаляемой записи
     * @return true - при успешном удалении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteProgressUser(ProgressUserWrapper progressUserWrapper) throws ServerException{
        return progressUserService.deleteProgressUser(progressUserWrapper);
    }

}
