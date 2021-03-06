package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.FriendWrapper;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/friends")
public class FriendController  {

    private final FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService){
        this.friendService = friendService;
    }

    /**
     * Метод реагирует на запрос /friends/{id}, выполняет запрос к бд, возвращает список друзей указанного пользователя
     * @param id идентификатор пользователя
     * @return список экзепляров класса FriendWrapper (список друзей)
     * @throws ServerException в случае ошибки генерирует исключение
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<FriendWrapper> getAllFriendsUser(@PathVariable("id") Long id) throws ServerException{
        return friendService.getAllFriendsUser(id);
    }

}
