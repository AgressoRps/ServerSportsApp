package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.FriendWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/friends")
public class FriendRestController {

    private final FriendService friendService;

    @Autowired
    public FriendRestController(FriendService friendService){
        this.friendService = friendService;
    }

    /**
     * Метод реагирует на запрос /friends/add, выполняет запрос к бд
     * для добавления пользователю нового друга
     * @param friendWrapper содержит данные о пользователе и добавляемом друге
     * @return в случае успешного добавления нового друга - true
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addFriend(FriendWrapper friendWrapper) throws ServerException{
        return friendService.addFriend(friendWrapper);
    }

    /**
     * Метод реагирует на запрос /friends/delete, выполняет запрос к бд
     * для удаления указанной записи о друге
     * @param friendWrapper содержит идентификатор удаляемой записи
     * @return true - при успешном удалении
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteFriend(FriendWrapper friendWrapper) throws ServerException{
        return friendService.deleteFriend(friendWrapper.getId());
    }
}
