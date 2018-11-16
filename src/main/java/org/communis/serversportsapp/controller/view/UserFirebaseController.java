package org.communis.serversportsapp.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.UserFirebaseWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.UserFirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/user")
public class UserFirebaseController {

    private final UserFirebaseService userFirebaseService;

    @Autowired
    public UserFirebaseController(UserFirebaseService userFirebaseService){
        this.userFirebaseService = userFirebaseService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserFirebaseWrapper> getAllUsers() throws ServerException{
        return userFirebaseService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserFirebaseWrapper getById(@PathVariable("id") Long id) throws ServerException{
        return userFirebaseService.getUserById(id);
    }

    @RequestMapping(value = "/uid/{uid}", method = RequestMethod.GET)
    public UserFirebaseWrapper getByUid(@PathVariable("uid") String uid) throws ServerException{
        return userFirebaseService.getUserByUid(uid);
    }
}
