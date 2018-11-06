package org.communis.serversportsapp.controller.view;


import lombok.extern.log4j.Log4j2;
import org.communis.serversportsapp.dto.ProgressWrapper;
import org.communis.serversportsapp.exception.ServerException;
import org.communis.serversportsapp.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/progress")
public class ProgressController {

    private final ProgressService progressService;

    @Autowired
    public ProgressController(ProgressService progressService){
        this.progressService = progressService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ProgressWrapper> getProgress() throws ServerException{
        return progressService.getAllProgress();
    }
}
