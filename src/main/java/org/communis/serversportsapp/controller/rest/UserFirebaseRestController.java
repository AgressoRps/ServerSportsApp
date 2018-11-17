package org.communis.serversportsapp.controller.rest;

import org.communis.serversportsapp.dto.UserFirebaseWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.UserFirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user-firebase")
public class UserFirebaseRestController {

    private UserFirebaseService userFirebaseService;

    @Autowired
    public UserFirebaseRestController(UserFirebaseService userFirebaseService){
        this.userFirebaseService = userFirebaseService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(UserFirebaseWrapper userFirebaseWrapper) throws ServerException{
        return userFirebaseService.addUser(userFirebaseWrapper);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String test(UserFirebaseWrapper userFirebaseWrapper) throws ServerException{
        System.out.println(userFirebaseWrapper.getUid());
        return "true";
    }
}
